package org.home;

import org.home.remote.RemoteControl;

import org.home.device.*;
import org.home.command.*;

public class RemoteControlClient {
    public static void main(String args[]) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);

        CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);

        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        remoteControl.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
        remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand);
        remoteControl.setCommand(3, stereoOnWithCDCommand, stereoOffCommand);

        remoteControl.setCommand(4, ceilingFanMediumCommand, ceilingFanOffCommand);
        remoteControl.setCommand(5, ceilingFanHighCommand, ceilingFanOffCommand);

        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPressed();

        remoteControl.onButtonWasPressed(1);
        remoteControl.offButtonWasPressed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPressed();

        remoteControl.onButtonWasPressed(2);
        remoteControl.offButtonWasPressed(2);
        remoteControl.onButtonWasPressed(3);
        remoteControl.offButtonWasPressed(3);

        remoteControl.onButtonWasPressed(4);
        remoteControl.offButtonWasPressed(4);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPressed();

        remoteControl.onButtonWasPressed(5);;
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPressed();
    }
}
