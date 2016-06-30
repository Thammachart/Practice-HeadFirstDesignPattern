package org.sim.adapters;

import org.sim.behaviors.Quackable;
import org.sim.geese.*;
import org.sim.observers.Observer;
import org.sim.observers.ObservableHelper;

public class GooseAsQuackableAdapter implements Quackable {
    private Goose goose;
    private ObservableHelper helper;

    public GooseAsQuackableAdapter(Goose goose) {
        this.goose = goose;
        this.helper = new ObservableHelper(this);
    }

    @Override
    public void quack() {
        goose.honk();
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        helper.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        helper.notifyObservers();
    }
}
