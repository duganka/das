package com.github.duganka.das.domain;

import com.google.common.collect.ImmutableList;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author vadik
 */
public enum PaymentType {

    CASH, CREDIT_CARD;

    private static final ImmutableList<PaymentType> ALL = ImmutableList.of(
            CASH, CREDIT_CARD, CREDIT_CARD, CREDIT_CARD
    );

    public static PaymentType randomType() {
        return ALL.get(ThreadLocalRandom.current().nextInt(ALL.size()));
    }

}
