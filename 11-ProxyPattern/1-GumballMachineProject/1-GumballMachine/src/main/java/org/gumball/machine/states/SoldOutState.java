package org.gumball.machine.states;

import org.gumball.machine.GumballMachine;

public class SoldOutState extends State {
    public SoldOutState(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("There is no gumball anymore, sorry...");
    }

    @Override
    public void dispense() {
        System.out.println("No more gumball for you...");
    }

    @Override
    public void refill(int gumballs) {
        System.out.println("Refilling the machine!");
        machine.refillGumBall(gumballs);
        machine.setState(machine.getNoQuarterState());
    }

    @Override
    public String toString() {
        return "sold out";
    }
}
