package com.github.duganka.das;

import com.github.duganka.das.domain.DeliveryType;
import com.github.duganka.das.domain.PaymentType;
import com.github.duganka.das.domain.Product;
import com.github.duganka.das.domain.ProductPurchaseEvent;
import com.github.duganka.das.domain.ProductViewEvent;
import com.github.duganka.das.domain.User;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;

import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author vadik
 */
public class EventsGenerator {

    private static final String VISITED_PRODUCTS = "visited-products";
    private static final String BOUGHT_PRODUCTS = "bought-products";

    public static void main(String[] args) {
        Preconditions.checkArgument(args.length > 0, "At least one Kafka broker address is expected");

        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Joiner.on(",").join(args));
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        final UserRegistry userRegistry = new UserRegistry(1000);
        final ProductCatalog productCatalog = new ProductCatalog();

        try (final KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            final long now = DateTimeUtils.currentTimeMillis();
            final long monthAgo = now - Days.days(30).toStandardDuration().getMillis();

            for (long millis = monthAgo, count = 0; millis <= now; millis += 1000L, ++count) {
                final DateTime timestamp = new DateTime(millis, DateTimeZone.UTC);
                User user = null;
                Product product = null;
                for (long i = 0; i < 10; ++i) {
                    user = userRegistry.randomUser();
                    product = productCatalog.randomProduct();
                    final ProductViewEvent event = new ProductViewEvent(timestamp, user, product, ThreadLocalRandom.current().nextBoolean());
                    producer.send(new ProducerRecord<String, String>(VISITED_PRODUCTS, event.toCsv()));
                }

                final ProductPurchaseEvent event = new ProductPurchaseEvent(timestamp, user, product, PaymentType.randomType(), DeliveryType.randomType());
                producer.send(new ProducerRecord<String, String>(BOUGHT_PRODUCTS, event.toCsv()));

                if (count % 1000 == 0) {
                    System.out.println("Current ts = " + timestamp);
                }
            }
        }
    }

}
