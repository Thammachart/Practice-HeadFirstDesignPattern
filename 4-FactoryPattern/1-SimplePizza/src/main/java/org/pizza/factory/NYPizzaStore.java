package org.pizza.factory;

import org.pizza.pizza.Pizza;
import org.pizza.pizza.NYStyleCheesePizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        }

        return null;
    }
}
