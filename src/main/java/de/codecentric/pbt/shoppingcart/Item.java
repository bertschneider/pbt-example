package de.codecentric.pbt.shoppingcart;

import org.javamoney.moneta.Money;

import java.util.Objects;

public class Item {

    private final String name;
    private final Money cost;

    public Item(String name, Money cost) {
        this.name = name;
        this.cost = cost;
    }

    public Money getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(cost, item.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
