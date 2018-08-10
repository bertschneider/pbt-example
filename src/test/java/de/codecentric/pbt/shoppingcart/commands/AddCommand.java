package de.codecentric.pbt.shoppingcart.commands;

import de.codecentric.pbt.shoppingcart.Item;
import de.codecentric.pbt.shoppingcart.ShoppingCart;
import org.javamoney.moneta.Money;
import org.quicktheories.core.stateful.Command;

public class AddCommand implements Command<ShoppingCart, Money> {

    private final Item item;
    private final int amount;

    public AddCommand(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    @Override
    public void run(ShoppingCart shoppingCart) {
        shoppingCart.add(item, amount);
    }

    @Override
    public Money nextState(Money currentState) {
        return currentState.add(item.getCost().multiply(amount)); // Is this already duplication?
    }

    @Override
    public String toString() {
        return "AddCommand{" +
                "item='" + item + '\'' +
                ", amount=" + amount +
                '}';
    }

}
