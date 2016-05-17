package org.sim.duck.adapter;

import org.sim.duck.Duck;
import org.sim.turkey.Turkey;

public class DuckAsTurkeyAdapter implements Turkey {
    Duck duck;

    public DuckAsTurkeyAdapter(Duck turkey) {
        this.duck = duck;
    }

    @Override
    public void fly() {
        duck.fly();
    }

    @Override
    public void gobble() {
        duck.quack();
    }
}
