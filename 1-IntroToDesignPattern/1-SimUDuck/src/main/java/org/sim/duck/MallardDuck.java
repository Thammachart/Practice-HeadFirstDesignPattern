package org.sim.duck;

import org.sim.flying.FlyWithWings;
import org.sim.quacking.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("MallardDuck");
    }
}
