package org.home.command;

import org.home.device.CeilingFan;

import org.home.Utilities;

public class CeilingFanOffCommand implements Command {
    CeilingFan ceilingFan;
    int previousSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        Utilities.setPreviousSpeed(ceilingFan,previousSpeed);
    }
}
