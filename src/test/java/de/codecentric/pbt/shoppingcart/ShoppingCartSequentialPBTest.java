package de.codecentric.pbt.shoppingcart;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.quicktheories.core.Gen;
import org.quicktheories.core.stateful.Command;
import org.quicktheories.core.stateful.Sequential;

import java.util.List;

import static de.codecentric.pbt.shoppingcart.gen.CommandGen.addCommands;
import static de.codecentric.pbt.shoppingcart.gen.CommandGen.resetCommands;
import static de.codecentric.pbt.shoppingcart.util.Euro.euro;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.lists;

class ShoppingCartSequentialPBTest {

    @Test
    void addingItemsIncreasesTheCost() {
        qt()
                .forAll(lists().of(addCommands()).ofSizeBetween(0, 10))
                .checkAssert((commands) ->
                        Sequential.modelCheck(euro(0), commands,
                                (model) -> new ShoppingCart(),
                                (sut) -> sut.cost())
                );
    }

    @Test
    void addingAndResettingCalculatesTheCorrectCost() {
        Gen<List<Command<ShoppingCart, Money>>> commandSequences = lists()
                .of(addCommands().mix(resetCommands(), 10))
                .ofSizeBetween(0, 10);

        qt()
                .withExamples(5000)
                .forAll(commandSequences)
                .checkAssert((commands) ->
                        Sequential.modelCheck(euro(0), commands,
                                (model) -> new ShoppingCart(),
                                (sut) -> sut.cost())
                );
    }

}
