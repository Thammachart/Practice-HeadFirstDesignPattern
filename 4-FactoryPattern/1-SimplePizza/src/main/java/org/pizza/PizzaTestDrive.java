package org.pizza;

import org.pizza.factory.*;
import org.pizza.pizza.*;

public class PizzaTestDrive {
    public static void main(String args[]) {
        PizzaStore myStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = myStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
