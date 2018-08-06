package de.codecentric.pbt.shoppingcart;

import org.javamoney.moneta.Money;

public class Euro {

    public static Money euro(Number amount) {
        return Money.of(amount, "EUR");
    }

    private Euro() {
    }
}
