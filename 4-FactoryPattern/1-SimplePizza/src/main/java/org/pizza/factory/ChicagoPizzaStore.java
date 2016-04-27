package org.pizza.factory;

import org.pizza.pizza.Pizza;
import org.pizza.pizza.ChicagoStyleCheesePizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }

        return null;
    }
}
