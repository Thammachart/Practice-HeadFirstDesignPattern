package org.gumball;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import org.gumball.monitor.GumballMonitor;
import org.gumball.machine.remote.GumballMachineRemote;

public class GumballMonitorTestDrive {
    public static void main(String args[]) {
        String machineNames[] = args;

        GumballMonitor monitors[] = new GumballMonitor[machineNames.length];

        for(int i = 0; i < machineNames.length; i++) {
            try {
                Registry registry = LocateRegistry.getRegistry();
                GumballMachineRemote machine = (GumballMachineRemote) registry.lookup(machineNames[i]);

                monitors[i] = new GumballMonitor(machine);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        for(GumballMonitor monitor : monitors) {
            monitor.report();
        }
    }
}
