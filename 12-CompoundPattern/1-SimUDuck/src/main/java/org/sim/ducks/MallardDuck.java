package org.sim.ducks;

import org.sim.behaviors.Quackable;

public class MallardDuck implements Quackable {

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
