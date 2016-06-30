package org.sim.observers;

public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
