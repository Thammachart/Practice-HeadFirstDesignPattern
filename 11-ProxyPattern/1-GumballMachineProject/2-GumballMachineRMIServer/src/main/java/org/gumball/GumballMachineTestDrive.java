package org.gumball;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import org.gumball.machine.GumballMachine;
import org.gumball.machine.remote.GumballMachineRemote;

public class GumballMachineTestDrive {
    public static void main(String args[]) {
        if(args.length < 3) {
            System.err.println("<remote name> <location> <number of gumballs>");
            System.exit(1);
        }

        try {
            String name = args[0];
            String location = args[1];
            int count = Integer.parseInt(args[2]);

            GumballMachineRemote machine = new GumballMachine(location, count);
            GumballMachineRemote stub = (GumballMachineRemote) UnicastRemoteObject.exportObject(machine, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
