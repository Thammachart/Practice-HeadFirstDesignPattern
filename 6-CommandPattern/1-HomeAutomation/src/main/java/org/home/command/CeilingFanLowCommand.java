package org.home.command;

import org.home.device.CeilingFan;

import org.home.Utilities;

public class CeilingFanLowCommand implements Command {
    CeilingFan ceilingFan;
    int previousSpeed;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
    }

    @Override
    public void undo() {
        Utilities.setPreviousSpeed(ceilingFan,previousSpeed);
    }
}
