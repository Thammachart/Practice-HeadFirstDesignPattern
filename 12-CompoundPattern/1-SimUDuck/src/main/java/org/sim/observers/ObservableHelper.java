package org.sim.observers;

import java.util.List;
import java.util.ArrayList;

public class ObservableHelper implements QuackObservable {
    private List<Observer> observers;
    private QuackObservable duck;

    public ObservableHelper(QuackObservable duck) {
        this.observers = new ArrayList<>();
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(duck);
        }
    }
}
