package com.github.duganka.das.domain;

import com.google.common.collect.ImmutableList;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author vadik
 */
public enum DeliveryType {
    FROM_STORE, COURIER, DHL;

    private static final ImmutableList<DeliveryType> ALL = ImmutableList.of(
            FROM_STORE, FROM_STORE, COURIER, DHL, DHL, DHL, DHL
    );

    public static DeliveryType randomType() {
        return ALL.get(ThreadLocalRandom.current().nextInt(ALL.size()));
    }

}
