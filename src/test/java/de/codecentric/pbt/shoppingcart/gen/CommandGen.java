package de.codecentric.pbt.shoppingcart.gen;

import de.codecentric.pbt.shoppingcart.Item;
import de.codecentric.pbt.shoppingcart.ShoppingCart;
import de.codecentric.pbt.shoppingcart.commands.AddCommand;
import de.codecentric.pbt.shoppingcart.commands.ResetCommand;
import org.javamoney.moneta.Money;
import org.quicktheories.core.Gen;
import org.quicktheories.core.stateful.Command;

import java.util.function.BiFunction;

import static de.codecentric.pbt.shoppingcart.gen.ItemGen.items;
import static org.quicktheories.generators.SourceDSL.integers;

public class CommandGen {

    public static Gen<Command<ShoppingCart, Money>> generateCommand(BiFunction<Item, Integer, Command<ShoppingCart, Money>> gen) {
        Gen<Item> items = items();
        Gen<Integer> amounts = integers().allPositive();
        return items.zip(amounts, gen);
    }

    public static Gen<Command<ShoppingCart, Money>> addCommands() {
        return generateCommand((item, amount) -> new AddCommand(item, amount));
    }

    public static Gen<Command<ShoppingCart, Money>> resetCommands() {
        return generateCommand((item, amount) -> new ResetCommand());
    }
}
