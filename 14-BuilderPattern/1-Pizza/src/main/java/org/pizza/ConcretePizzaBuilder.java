package org.pizza;

public class ConcretePizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public ConcretePizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough(String dough) {
        this.pizza.setDough(dough);
    }

    @Override
    public void buildSauce(String sauce) {
        this.pizza.setSauce(sauce);
    }

    @Override
    public void buildTopping(String topping) {
        this.pizza.setTopping(topping);
    }

    @Override
    public Pizza getPizza() {
        Pizza result = pizza;
        pizza = new Pizza();
        return result;
    }
}
