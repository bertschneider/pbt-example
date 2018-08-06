package de.codecentric.pbt.shoppingcart;

import org.javamoney.moneta.Money;

import java.util.HashMap;
import java.util.Map;

import static de.codecentric.pbt.shoppingcart.Euro.euro;

public class ShoppingCart {

    private Map<Item, LineItem> lineItems = new HashMap<>();

    public Money cost() {
        return lineItems.values().stream()
                .map(LineItem::cost)
                .reduce(euro(0), Money::add);
    }

    public void add(Item item, int amount) {
        lineItems.put(item, createLineItem(item, amount));
    }

    private LineItem createLineItem(Item item, int amount) {
        if (lineItems.containsKey(item)) {
            return new LineItem(item, lineItems.get(item).getAmount() + amount);
        } else {
            return new LineItem(item, amount);
        }
    }

    public int distinctItemCount() {
        return lineItems.keySet().size();
    }
}
