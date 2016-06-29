package org.sim.ducks;

import org.sim.behaviors.Quackable;

public class RedheadDuck implements Quackable {

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
