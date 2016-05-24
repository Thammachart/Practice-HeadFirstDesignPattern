package org.starbuzz.beverage.template.hook;

import org.starbuzz.Util;

public class TeaWithHook extends CaffeineBeverageWithHook {
    private Util util;

    public TeaWithHook(Util util) {
        this.util = util;
    }

    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }

    @Override
    boolean customerWantsCondiments() {
        System.out.print("Lemon? :");
        String answer = util.getUserInput();
        return util.parseAnswer(answer);
    }
}
