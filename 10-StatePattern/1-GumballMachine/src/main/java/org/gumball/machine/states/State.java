package org.gumball.machine.states;

import org.gumball.machine.GumballMachine;

public abstract class State {
    protected GumballMachine machine;

    public State(GumballMachine gumballMachine) {
        this.machine = gumballMachine;
    }

    public abstract void insertQuarter();
    public abstract void ejectQuarter();
    public abstract void turnCrank();
    public abstract void dispense();

    public abstract String toString();
}
