package org.sim.ducks;

import org.sim.behaviors.Quackable;
import org.sim.observers.ObservableHelper;
import org.sim.observers.Observer;

public class DuckCall implements Quackable {

    private ObservableHelper observable;

    public DuckCall() {
        observable = new ObservableHelper(this);
    }

    @Override
    public void quack() {
        System.out.println("Kwak");
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
