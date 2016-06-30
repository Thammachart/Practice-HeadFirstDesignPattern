package org.sim;

import org.sim.observers.QuackObservable;
import org.sim.observers.Observer;

public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck.getClass().getSimpleName() + " just quacked");
    }
}
