package de.codecentric.pbt.shoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static de.codecentric.pbt.shoppingcart.util.Euro.euro;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
    }

    // ------ Adding item cost ------

    @Test
    void newShoppingCartHasNoCost() {
        assertThat(shoppingCart.cost(), is(euro(0)));
    }

    @Test
    void addingAnItemToTheShoppingCartIncreasesTheCostByTheItemCost() {
        Item item = new Item("Some Item", euro(3.50));
        shoppingCart.add(item, 1);
        assertThat(shoppingCart.cost(), is(euro(3.50)));
    }

    @Test
    void addingAGreaterAmountOfAnItemToTheShoppingCartIncreasesTheCostBasedOnTheAmount() {
        Item item = new Item("Some Item", euro(2));
        shoppingCart.add(item, 5);
        assertThat(shoppingCart.cost(), is(euro(10)));
    }

    @Test
    void addingMultipleItemsToTheShoppingCartIncreasesTheCostBasedOnTheItems() {
        shoppingCart.add(new Item("First Item", euro(10)), 2);
        shoppingCart.add(new Item("Second Item", euro(2.50)), 4);
        assertThat(shoppingCart.cost(), is(euro(30)));
    }

    @Test
    void addingTheSameItemMultipleTimesResetsTheCostToTheSecondAmount() {
        Item someItem = new Item("Some Item", euro(1));
        shoppingCart.add(someItem, 1);
        shoppingCart.add(someItem, 5);
        assertThat(shoppingCart.cost(), is(euro(5)));
    }

    @Test
    void addingAnItemToTheShoppingCartAddsAtLeastOneItem() {
        Item item = new Item("Some Item", euro(1));
        shoppingCart.add(item, -1);
        assertThat(shoppingCart.cost(), is(euro(1)));
    }

    // ------ Removing item cost ---

    @Test
    void removingAnItemLowersTheCostBasedOnTheItemAmount() {
        Item someItem = new Item("Some Item", euro(10));
        shoppingCart.add(someItem, 10);
        shoppingCart.remove(someItem, 5);
        assertThat(shoppingCart.cost(), is(euro(50)));
    }

    @Test
    void removingMoreAmountOfAnItemAsPresentRemovesAllCostsOfTheItem() {
        Item someItem = new Item("Some Item", euro(10));
        shoppingCart.add(someItem, 1);
        shoppingCart.remove(someItem, 2);
        assertThat(shoppingCart.cost(), is(euro(0)));
    }

    @Test
    void removingAnUnknownItemDoesNothing() {
        shoppingCart.add(new Item("Some Item", euro(10)), 10);
        shoppingCart.remove(new Item("Some other Item", euro(10)), 5);
        assertThat(shoppingCart.cost(), is(euro(100)));
    }

    // ------ Reset ------

    @Test
    void resetEmptiesTheShoppingCart() {
        shoppingCart.add(new Item("First Item", euro(1)), 1);
        shoppingCart.add(new Item("Second Item", euro(2)), 2);
        shoppingCart.reset();
        assertThat(shoppingCart.cost(), is(euro(0)));
    }
}
