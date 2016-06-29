package org.sim.factories;

import org.sim.adapters.GooseAsQuackableAdapter;
import org.sim.behaviors.Quackable;
import org.sim.decorators.QuackCounter;
import org.sim.ducks.*;
import org.sim.geese.*;

public class CountingDuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

    @Override
    public Quackable createGooseDuck() {
        return new GooseAsQuackableAdapter(new Goose());
    }
}
