package com.github.duganka.das.domain;

import com.github.duganka.das.util.CsvUtil;

/**
 * @author vadik
 */
public class Product implements ToCsv {

    private final String category;
    private final String subCategory;
    private final String name;
    private final float price;

    public Product(String category, String subCategory, String name, float price) {
        this.category = category;
        this.subCategory = subCategory;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toCsv() {
        return CsvUtil.JOINER.join(category, subCategory, price);
    }

    @Override
    public String toString() {
        return name;
    }

}
