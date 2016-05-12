package org.home;

import org.home.device.Light;
import org.home.device.GarageDoor;

import org.home.command.Command;
import org.home.command.LightOnCommand;
import org.home.command.GarageDoorOpenCommand;

public class RemoteControlClient {
    public static void main(String args[]) {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();

        Command lightOn = new LightOnCommand(light);
        Command garageDoorOpen = new GarageDoorOpenCommand(garageDoor);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        remote.setCommand(garageDoorOpen);
        remote.buttonWasPressed();
    }
}
