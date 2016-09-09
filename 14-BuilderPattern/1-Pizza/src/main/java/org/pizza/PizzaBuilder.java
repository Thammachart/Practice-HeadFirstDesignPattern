package org.pizza;

public interface PizzaBuilder {
    public void buildDough(String dough);
    public void buildSauce(String sauce);
    public void buildTopping(String topping);
    public Pizza getPizza();
}
