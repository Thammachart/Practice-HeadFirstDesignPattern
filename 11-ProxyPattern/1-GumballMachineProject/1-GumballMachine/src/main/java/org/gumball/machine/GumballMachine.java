package org.gumball.machine;

import java.rmi.RemoteException;

import org.gumball.machine.remote.GumballMachineRemote;
import org.gumball.machine.states.*;

public class GumballMachine implements GumballMachineRemote {
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State winnerState;

    private State currentState;
    private int remainingGumball;

    private String location;

    public GumballMachine(String location, int remainingGumball) {
        this.soldOutState = new SoldOutState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);

        this.remainingGumball = remainingGumball;
        this.currentState = this.remainingGumball > 0 ? noQuarterState : soldOutState;

        this.location = location;
    }

    public GumballMachine(int remainingGumball) {
        this("Nowhere",remainingGumball);
    }

    public State getSoldOutState() {
        return this.soldOutState;
    }

    public State getNoQuarterState() {
        return this.noQuarterState;
    }

    public State getHasQuarterState() {
        return this.hasQuarterState;
    }

    public State getSoldState() {
        return this.soldState;
    }

    public State getWinnerState() {
        return this.winnerState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void refillGumBall(int gumballs) {
        this.remainingGumball += gumballs;
    }

    public void releaseBall() {
        System.out.println("Gumball comes rolling out the slot");
        if(this.remainingGumball != 0)
            this.remainingGumball--;
    }

    public void refill(int gumballs) {
        this.currentState.refill(gumballs);
    }

    public void insertQuarter() {
        this.currentState.insertQuarter();
    }

    public void ejectQuarter() {
        this.currentState.ejectQuarter();
    }

    public void turnCrank() {
        this.currentState.turnCrank();
        this.currentState.dispense();
    }

    @Override
    public int getRemainingGumBall() {
        return this.remainingGumball;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getStringMachineState() {
        return this.currentState.toString();
    }

    @Override
    public String toString() {
        return "Gumball Machine @ " + location + "\n" +
                "Inventory: " + this.remainingGumball + "\n" +
                "Machine is " + this.getStringMachineState() + "\n\n";
    }
}
