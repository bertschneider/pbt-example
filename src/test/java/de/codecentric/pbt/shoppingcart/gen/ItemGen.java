package de.codecentric.pbt.shoppingcart.gen;

import de.codecentric.pbt.shoppingcart.Item;
import org.javamoney.moneta.Money;
import org.quicktheories.core.Gen;

import static org.quicktheories.generators.SourceDSL.strings;

public class ItemGen {

    public static Gen<Item> items() {
        Gen<String> names = strings().basicMultilingualPlaneAlphabet().ofLengthBetween(1, 5);
        Gen<Money> prices = EuroGen.euros();
        return names.zip(prices, Item::new);
    }

}
