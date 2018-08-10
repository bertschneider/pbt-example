package de.codecentric.pbt.shoppingcart.commands;

import de.codecentric.pbt.shoppingcart.ShoppingCart;
import org.javamoney.moneta.Money;
import org.quicktheories.core.stateful.Command;

import static de.codecentric.pbt.shoppingcart.util.Euro.euro;

public class ResetCommand implements Command<ShoppingCart, Money> {

    @Override
    public void run(ShoppingCart shoppingCart) {
        shoppingCart.reset();
    }

    @Override
    public Money nextState(Money currentState) {
        return euro(0);
    }

    @Override
    public String toString() {
        return "ResetCommand{}";
    }
}
