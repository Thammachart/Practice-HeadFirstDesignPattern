package org.sim.turkey.adapter;

import org.sim.duck.Duck;
import org.sim.turkey.Turkey;

public class TurkeyAsDuckAdapter implements Duck {
    Turkey turkey;

    public TurkeyAsDuckAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void fly() {
        for(int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}
