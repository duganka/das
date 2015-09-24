package com.github.duganka.das.domain;

import com.github.duganka.das.util.CsvUtil;
import org.joda.time.DateTime;

/**
 * @author vadik
 */
public class ProductViewEvent implements ToCsv {

    private final DateTime timestamp;
    private final User user;
    private final Product product;
    private final boolean adClick;

    public ProductViewEvent(DateTime timestamp, User user, Product product, boolean adClick) {
        this.timestamp = timestamp;
        this.user = user;
        this.product = product;
        this.adClick = adClick;
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

    public boolean isAdClick() {
        return adClick;
    }

    @Override
    public String toCsv() {
        return CsvUtil.JOINER.join(CsvUtil.toCsv(timestamp), user.toCsv(), product.toCsv(), adClick);
    }

    @Override
    public String toString() {
        return user + " viewed " + product + " at " + timestamp.toString();
    }

}
