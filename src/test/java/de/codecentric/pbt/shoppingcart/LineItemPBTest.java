package de.codecentric.pbt.shoppingcart;

import org.junit.jupiter.api.Test;

import static de.codecentric.pbt.shoppingcart.gen.ItemGen.items;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;

class LineItemPBTest {

    @Test
    void usesOnlyPositiveAmounts() {
        qt().forAll(items(), integers().all())
                .checkAssert((item, amount) -> {
                    LineItem lineItem = new LineItem(item, amount);
                    System.out.println(lineItem);
                    assertThat(lineItem.getAmount(), is(greaterThan(0)));
                });
    }
}
