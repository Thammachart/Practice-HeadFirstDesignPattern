package org.gumball.machine.states;

import org.gumball.machine.GumballMachine;

public class NoQuarterState extends State {
    public NoQuarterState(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        machine.setState(machine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there is no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("Quarter first...");
    }

    @Override
    public String toString() {
        return "waiting for quarter";
    }
}
