package org.sim.decorators;

import org.sim.behaviors.Quackable;
import org.sim.observers.Observer;

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

    @Override
    public void registerObserver(Observer observer) {
        quackable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        quackable.notifyObservers();
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }

    public static void resetQuacks() {
        numberOfQuacks = 0;
    }
}
