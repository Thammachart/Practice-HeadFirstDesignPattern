package org.sim.ducks;

import org.sim.behaviors.Quackable;
import org.sim.observers.ObservableHelper;
import org.sim.observers.Observer;

public class MallardDuck implements Quackable {

    private ObservableHelper observable;

    public MallardDuck() {
        observable = new ObservableHelper(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
