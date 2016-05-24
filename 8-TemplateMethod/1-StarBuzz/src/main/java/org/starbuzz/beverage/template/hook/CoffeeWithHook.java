package org.starbuzz.beverage.template.hook;

import org.starbuzz.Util;

public class CoffeeWithHook extends CaffeineBeverageWithHook {
    private Util util;

    public CoffeeWithHook(Util util) {
        this.util = util;
    }

    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    @Override
    boolean customerWantsCondiments() {
        System.out.print("Milk and Sugar? :");
        String answer = util.getUserInput();
        return util.parseAnswer(answer);
    }
}
