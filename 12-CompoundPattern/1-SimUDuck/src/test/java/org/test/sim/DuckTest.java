package org.test.sim;

import org.junit.Test;

import org.sim.behaviors.Quackable;
import org.sim.factories.*;
import org.sim.adapters.GooseAsQuackableAdapter;
import org.sim.decorators.QuackCounter;
import org.sim.ducks.*;
import org.sim.geese.*;

public class DuckTest {

    @Test
    public void simulate() {
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = duckFactory.createGooseDuck();

        System.out.println("\nDuck Simulator: With Abstract Factory");
        System.out.println("================");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    private void simulate(Quackable quackable) {
        quackable.quack();
    }
}
