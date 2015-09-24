package com.github.duganka.das;

import com.github.duganka.das.domain.Product;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author vadik
 */
public class ProductCatalog {

    // Categories
    private static final String ELECTRONICS = "Electronics";
    private static final String GROCERY = "Grocery";

    // Sub-categories
    private static final String TV = "TV";
    private static final String PHONES = "Phones";
    private static final String LAPTOPS = "Laptops";

    private static final String FRUITS = "Fruits";
    private static final String VEGETABLES = "Vegetables";

    private final ImmutableList<Product> products;

    public ProductCatalog() {
        final List<Product> products = new ArrayList<>();

        products.addAll(generate(ELECTRONICS, TV, "LG 2013", 1000, 1));
        products.addAll(generate(ELECTRONICS, TV, "LG 2014", 2000, 5));
        products.addAll(generate(ELECTRONICS, TV, "LG 2015", 3000, 10));
        products.addAll(generate(ELECTRONICS, TV, "Samsung 2013", 1500, 2));
        products.addAll(generate(ELECTRONICS, TV, "Samsung 2014", 2500, 8));
        products.addAll(generate(ELECTRONICS, TV, "Samsung 2015", 3500, 15));
        products.addAll(generate(ELECTRONICS, TV, "Sony 2013", 2000, 1));
        products.addAll(generate(ELECTRONICS, TV, "Sony 2014", 3000, 10));
        products.addAll(generate(ELECTRONICS, TV, "Sony 2015", 4000, 6));

        products.addAll(generate(ELECTRONICS, PHONES, "LG G2", 1000, 1));
        products.addAll(generate(ELECTRONICS, PHONES, "LG G3", 2000, 3));
        products.addAll(generate(ELECTRONICS, PHONES, "LG G4", 3000, 6));
        products.addAll(generate(ELECTRONICS, PHONES, "Samsung S4", 1500, 5));
        products.addAll(generate(ELECTRONICS, PHONES, "Samsung S5", 2500, 10));
        products.addAll(generate(ELECTRONICS, PHONES, "Samsung S6", 3500, 15));
        products.addAll(generate(ELECTRONICS, PHONES, "iPhone 4", 2000, 4));
        products.addAll(generate(ELECTRONICS, PHONES, "iPhone 5", 3000, 10));
        products.addAll(generate(ELECTRONICS, PHONES, "iPhone 6", 4000, 6));

        products.addAll(generate(ELECTRONICS, LAPTOPS, "Asus 2013", 1000, 1));
        products.addAll(generate(ELECTRONICS, LAPTOPS, "Asus 2014", 2000, 2));
        products.addAll(generate(ELECTRONICS, LAPTOPS, "Asus 2015", 3000, 3));
        products.addAll(generate(ELECTRONICS, LAPTOPS, "MSI 2013", 1500, 4));
        products.addAll(generate(ELECTRONICS, LAPTOPS, "MSI 2014", 2500, 5));
        products.addAll(generate(ELECTRONICS, LAPTOPS, "MSI 2015", 3500, 6));
        products.addAll(generate(ELECTRONICS, LAPTOPS, "MacBook 2013", 2000, 7));
        products.addAll(generate(ELECTRONICS, LAPTOPS, "MacBook 2014", 3000, 8));
        products.addAll(generate(ELECTRONICS, LAPTOPS, "MacBook 2015", 4000, 9));

        products.addAll(generate(GROCERY, FRUITS, "Fresh Watermelon", 7, 1));
        products.addAll(generate(GROCERY, FRUITS, "Rotten Watermelon", 5, 5));
        products.addAll(generate(GROCERY, FRUITS, "Green Apple", 5, 10));
        products.addAll(generate(GROCERY, FRUITS, "Red Apple", 2, 20));

        products.addAll(generate(GROCERY, VEGETABLES, "Potato", 2, 12));
        products.addAll(generate(GROCERY, VEGETABLES, "Onion", 1, 10));

        this.products = ImmutableList.copyOf(products);
    }

    public Product randomProduct() {
        return products.get(ThreadLocalRandom.current().nextInt(products.size()));
    }

    private static List<Product> generate(String category, String subCategory, String name, float price, int popularity) {
        return Collections.nCopies(popularity, new Product(category, subCategory, name, price));
    }

}
