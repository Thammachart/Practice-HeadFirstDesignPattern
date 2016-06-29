package org.sim.decorators;

import org.sim.behaviors.Quackable;

public class QuackCounter implements Quackable {
    private Quackable quackable;
    private static int numberOfQuacks = 0;

    public QuackCounter(Quackable quackable) {
        this.quackable = quackable;
    }

    @Override
    public void quack() {
        quackable.quack();
        numberOfQuacks++;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }
}
