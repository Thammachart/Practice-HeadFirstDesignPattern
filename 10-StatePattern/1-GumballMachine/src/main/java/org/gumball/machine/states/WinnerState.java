package org.gumball.machine.states;

import org.gumball.machine.GumballMachine;

public class WinnerState extends State {
    public WinnerState(GumballMachine machine) {
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
        machine.releaseBall();
        if(machine.getRemainingGumBall() == 0) {
            machine.setState(machine.getSoldOutState());
        } else {
            machine.releaseBall();
            System.out.println("YOU ARE A WINNER!");
            if(machine.getRemainingGumBall() > 0) {
                machine.setState(machine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs!");
                machine.setState(machine.getSoldOutState());
            }
        }
    }

    @Override
    public String toString() {
        return "WINNER";
    }
}
