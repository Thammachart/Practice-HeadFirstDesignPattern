package org.sim.composite;

import java.util.List;
import java.util.ArrayList;

import org.sim.observers.Observer;

import org.sim.behaviors.Quackable;

public class Flock implements Quackable {
    private List<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        for(Quackable quacker : quackers) {
            quacker.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        for(Quackable quacker : quackers) {
            quacker.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for(Quackable quacker : quackers) {
            quacker.notifyObservers();
        }
    }
}
