package pl.devfoundry;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {
        //given
        Meal meal = new Meal(35);

        //when
        int discountedPrice = meal.getDiscountedPrice(7);

        //then
        assertEquals(28, discountedPrice);
        assertThat(discountedPrice, equalTo(28));
    }
    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame() {
        //given
        Meal pizza = new Meal(10, "Pizza");
        Meal pizza1 = new Meal(10, "Pizza");

        //then
        assertEquals(pizza, pizza1, "Checking if two meals are equal");
        assertThat(pizza, not(sameInstance(pizza1)));



    }



}