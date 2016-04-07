package org.sim;

import org.sim.duck.Duck;
import org.sim.duck.MallardDuck;
import org.sim.duck.ModelDuck;

import org.sim.flying.FlyRocketPowered;

public class MiniDuckSimulator {

    public static void main(String args[]) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
