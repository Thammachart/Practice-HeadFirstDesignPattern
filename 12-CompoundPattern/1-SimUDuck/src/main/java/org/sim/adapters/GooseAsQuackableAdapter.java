package org.sim.adapters;

import org.sim.behaviors.Quackable;
import org.sim.geese.*;

public class GooseAsQuackableAdapter implements Quackable {
    private Goose goose;

    public GooseAsQuackableAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
