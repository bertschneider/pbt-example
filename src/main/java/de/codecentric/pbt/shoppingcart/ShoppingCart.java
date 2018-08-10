package de.codecentric.pbt.shoppingcart;

import org.javamoney.moneta.Money;

import java.util.HashMap;
import java.util.Map;

import static de.codecentric.pbt.shoppingcart.util.Euro.euro;

public class ShoppingCart {

    private final Map<Item, LineItem> lineItems = new HashMap<>();

    public Money cost() {
        return lineItems.values().stream()
                .map(LineItem::cost)
                .reduce(euro(0), Money::add);
    }

    public void add(Item item, int amount) {
        LineItem lineItem = lineItems.get(item);
        if (lineItem != null) {
            lineItems.put(item, new LineItem(item, amount + lineItem.getAmount()));
        } else {
            lineItems.put(item, new LineItem(item, amount));
        }
    }

    public void remove(Item item, int amount) {
        LineItem lineItem = lineItems.get(item);
        if (lineItem != null) {
            int lineItemAmount = lineItem.getAmount();
            if (lineItemAmount > amount) {
                lineItems.put(item, new LineItem(item, lineItemAmount - amount));
            } else {
                lineItems.remove(item);
            }
        }
    }

    public void reset() {
        lineItems.clear();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "lineItems=" + lineItems +
                '}';
    }
}
