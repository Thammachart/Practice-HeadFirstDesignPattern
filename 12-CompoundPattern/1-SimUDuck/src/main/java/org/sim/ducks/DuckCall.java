package org.sim.ducks;

import org.sim.behaviors.Quackable;

public class DuckCall implements Quackable {

    @Override
    public void quack() {
        System.out.println("Kwak");
    }
}
