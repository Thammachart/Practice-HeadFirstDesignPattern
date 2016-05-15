package org.home.command;

import org.home.device.CeilingFan;

import org.home.Utilities;

public class CeilingFanHighCommand implements Command {
    CeilingFan ceilingFan;
    int previousSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        Utilities.setPreviousSpeed(ceilingFan,previousSpeed);
    }
}
