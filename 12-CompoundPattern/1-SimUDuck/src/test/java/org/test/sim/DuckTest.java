package org.test.sim;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.sim.behaviors.Quackable;
import org.sim.factories.*;
import org.sim.adapters.GooseAsQuackableAdapter;
import org.sim.decorators.QuackCounter;
import org.sim.composite.Flock;
import org.sim.observers.*;
import org.sim.ducks.*;
import org.sim.geese.*;
import org.sim.Quackologist;

public class DuckTest {

    private AbstractDuckFactory duckFactory = new CountingDuckFactory();
    private Quackable mallardDuck;
    private Quackable redheadDuck;
    private Quackable duckCall;
    private Quackable rubberDuck;
    private Quackable gooseDuck;

    @Before
    public void init() {
        QuackCounter.resetQuacks();
        mallardDuck = duckFactory.createMallardDuck();
        redheadDuck = duckFactory.createRedheadDuck();
        duckCall = duckFactory.createDuckCall();
        rubberDuck = duckFactory.createRubberDuck();
        gooseDuck = duckFactory.createGooseDuck();
    }

    @After
    public void deinit() {
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    @Test
    public void simulateWithFactoryAndDecorator() {
        System.out.println("\nDuck Simulator: With Abstract Factory");
        System.out.println("================");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
    }

    @Test
    public void simulateWithFactoryAndDecoratorAndComposite() {
        System.out.println("\nDuck Simulator: With Abstract Factory, and Composite -- Flocks");
        System.out.println("================");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        for(int i = 0; i < 4; i++)
            flockOfMallards.add(duckFactory.createMallardDuck());

        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);
    }

    @Test
    public void simulateWithObserver() {
        System.out.println("\nDuck Simulator: With Abstract Factory, and Composite -- Flocks, and Observers");
        System.out.println("================");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        for(int i = 0; i < 4; i++)
            flockOfMallards.add(duckFactory.createMallardDuck());

        flockOfDucks.add(flockOfMallards);

        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        simulate(flockOfDucks);
    }

    private void simulate(Quackable quackable) {
        quackable.quack();
    }
}
