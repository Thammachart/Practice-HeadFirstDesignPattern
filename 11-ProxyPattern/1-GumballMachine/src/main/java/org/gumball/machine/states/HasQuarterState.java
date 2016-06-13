package org.gumball.machine.states;

import org.gumball.machine.GumballMachine;

public class HasQuarterState extends State {
    public HasQuarterState(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        machine.setState(machine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        double winner = Math.random();
        if(winner < 0.1 && machine.getRemainingGumBall() > 1) {
            machine.setState(machine.getWinnerState());
        } else {
            machine.setState(machine.getSoldState());
        }
    }

    @Override
    public void refill(int gumballs) {
        System.out.println("No need to refill");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public String toString() {
        return "ready to crank";
    }
}
