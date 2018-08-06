package de.codecentric.pbt.shoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static de.codecentric.pbt.shoppingcart.Euro.euro;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
    }

    // ------ Cost ------

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
    void addingTheSameItemMultipleTimesIncreasesTheCostBasedOnBothTimes() {
        shoppingCart.add(new Item("Some Item", euro(1)), 1);
        shoppingCart.add(new Item("Some Item", euro(1)), 4);
        assertThat(shoppingCart.cost(), is(euro(5)));
    }
    
    // ------ LineItem count ------

    @Test
    void addingAnItemIncreasesTheAmountOfDistinctItems() {
        shoppingCart.add(new Item("Some Item", euro(2)), 1);
        assertThat(shoppingCart.distinctItemCount(), is(1));
    }

    @Test
    void addingMultipleItemsIncreasesTheAmountOfDistinctItemsEqually() {
        shoppingCart.add(new Item("First Item", euro(1)), 1);
        shoppingCart.add(new Item("Second Item", euro(2)), 2);
        assertThat(shoppingCart.distinctItemCount(), is(2));
    }

    @Test
    void addingTheSameItemAgainDoesNotIncreasesTheAmountOfDistinctItems() {
        shoppingCart.add(new Item("Item", euro(1)), 1);
        shoppingCart.add(new Item("Item", euro(1)), 2);
        assertThat(shoppingCart.distinctItemCount(), is(1));
    }
    
}
