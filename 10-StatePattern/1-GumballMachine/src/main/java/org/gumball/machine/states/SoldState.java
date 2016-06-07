package org.gumball.machine.states;

import org.gumball.machine.GumballMachine;

public class SoldState extends State {
    public SoldState(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void insertQuarter() {
       System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turnning twice doesn't give you another gumball");
    }

    @Override
    public void dispense() {
        System.out.println("Gumball comes rolling out the slot");
        machine.releaseBall();

        if(machine.getRemainingGumBall() == 0) {
            System.out.println("Oops, out of gumballs now!!!");
            machine.setState(machine.getSoldOutState());
        } else {
            machine.setState(machine.getNoQuarterState());
        }
    }

    @Override
    public String toString() {
        return "sold";
    }
}
