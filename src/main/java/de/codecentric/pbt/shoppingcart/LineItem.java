package de.codecentric.pbt.shoppingcart;

import org.javamoney.moneta.Money;

import java.util.Objects;

class LineItem {

    private final Item item;
    private final int amount;

    public LineItem(Item item, int amount) {
        this.item = item;
        this.amount = amount > 0 ? amount : 1;
    }

    public Money cost() {
        return item.getCost().multiply(amount);
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return amount == lineItem.amount &&
                Objects.equals(item, lineItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, amount);
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "item=" + item +
                ", amount=" + amount +
                '}';
    }
}
