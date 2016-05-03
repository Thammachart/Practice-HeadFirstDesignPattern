package org.pizza.ingredient.factory;

import org.pizza.ingredient.dough.Dough;
import org.pizza.ingredient.sauce.Sauce;
import org.pizza.ingredient.cheese.Cheese;
import org.pizza.ingredient.veggie.Veggie;
import org.pizza.ingredient.pepperoni.Pepperoni;
import org.pizza.ingredient.clam.Clam;

public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggie[] createVeggies();
    public Pepperoni createPepperoni();
    public Clam createClam();
}
