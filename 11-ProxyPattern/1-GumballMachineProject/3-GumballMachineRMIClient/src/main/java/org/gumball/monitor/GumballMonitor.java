package org.gumball.monitor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.gumball.machine.remote.GumballMachineRemote;

public class GumballMonitor {
    private GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine @ " + machine.getLocation());
            System.out.println("Current Inventory: " + machine.getRemainingGumBall());
            System.out.println("Current State: " + machine.getStringMachineState());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
