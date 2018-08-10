package de.codecentric.pbt.shoppingcart.util;

import org.javamoney.moneta.Money;

public class Euro {

    public static final Money ZERO_EUR = euro(0);

    public static Money euro(Number amount) {
        return Money.of(amount, "EUR");
    }

    private Euro() {
    }
}
