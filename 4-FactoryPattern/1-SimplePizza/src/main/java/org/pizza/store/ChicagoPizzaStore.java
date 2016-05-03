package org.pizza.store;

import org.pizza.pizza.*;
import org.pizza.ingredient.factory.PizzaIngredientFactory;
import org.pizza.ingredient.factory.ChicagoPizzaIngredientFactory;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        } else if(type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        }

        return pizza;
    }
}
