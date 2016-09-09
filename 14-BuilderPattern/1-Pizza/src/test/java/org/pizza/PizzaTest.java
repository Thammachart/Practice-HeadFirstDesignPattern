package org.pizza;

import org.junit.Test;
import static org.junit.Assert.*;

public class PizzaTest {

    @Test
    public void testPizza() {
        PizzaBuilder builder = new ConcretePizzaBuilder();
        Waiter waiter = new Waiter(builder);

        Pizza result = waiter.constructPizza();
        assertEquals("Pizza [dough=dough, sauce=sauce, topping=What topping? eiei]",result.toString());
    }
}
