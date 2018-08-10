package de.codecentric.pbt.shoppingcart;

import org.junit.jupiter.api.Test;

import static de.codecentric.pbt.shoppingcart.util.Euro.euro;
import static de.codecentric.pbt.shoppingcart.gen.ItemGen.items;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.quicktheories.QuickTheory.qt;

class ItemPBTest {

    @Test
    void usesOnlyPositiveAmounts() {
        qt().forAll(items())
                .checkAssert((item) ->
                        assertThat(item.getCost(), is(greaterThanOrEqualTo(euro(0)))));
    }
}
