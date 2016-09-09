package org.pizza;

public class Waiter {
    private PizzaBuilder builder;

    public Waiter(PizzaBuilder builder) {
        this.builder = builder;
    }

    public Pizza constructPizza() {
        builder.buildDough("dough");
        builder.buildSauce("sauce");
        builder.buildTopping("What topping? eiei");

        return builder.getPizza();
    }
}
