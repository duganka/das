package com.github.duganka.das.domain;

import com.github.duganka.das.util.CsvUtil;
import org.joda.time.DateTime;

/**
 * @author vadik
 */
public class ProductPurchaseEvent implements ToCsv {

    private final DateTime timestamp;
    private final User user;
    private final Product product;
    private final PaymentType paymentType;
    private final DeliveryType deliveryType;

    public ProductPurchaseEvent(DateTime timestamp, User user, Product product, PaymentType paymentType, DeliveryType deliveryType) {
        this.timestamp = timestamp;
        this.user = user;
        this.product = product;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    @Override
    public String toCsv() {
        return CsvUtil.JOINER.join(CsvUtil.toCsv(timestamp), user.toCsv(), product.toCsv(), paymentType, deliveryType);
    }

    @Override
    public String toString() {
        return user + " purchased " + product + " at " + timestamp.toString();
    }

}
