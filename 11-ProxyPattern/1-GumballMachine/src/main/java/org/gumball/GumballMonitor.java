package org.gumball;

import org.gumball.machine.GumballMachine;

public class GumballMonitor {
    private GumballMachine machine;

    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    public void report() {
        System.out.println("Gumball Machine @ " + machine.getLocation());
        System.out.println("Current Inventory: " + machine.getRemainingGumBall());
        System.out.println("Current State: " + machine.getStringMachineState());
    }
}
