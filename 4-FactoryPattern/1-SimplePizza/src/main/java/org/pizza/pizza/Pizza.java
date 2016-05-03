package org.pizza.pizza;

import org.pizza.ingredient.dough.Dough;
import org.pizza.ingredient.sauce.Sauce;
import org.pizza.ingredient.cheese.Cheese;
import org.pizza.ingredient.veggie.Veggie;
import org.pizza.ingredient.pepperoni.Pepperoni;
import org.pizza.ingredient.clam.Clam;

public abstract class Pizza {
    String name;

    Dough dough;
    Sauce sauce;
    Veggie veggie[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clam clam;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
