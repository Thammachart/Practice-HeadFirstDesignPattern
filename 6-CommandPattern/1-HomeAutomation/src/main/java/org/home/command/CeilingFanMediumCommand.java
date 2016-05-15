package org.home.command;

import org.home.device.CeilingFan;

import org.home.Utilities;

public class CeilingFanMediumCommand implements Command {
    CeilingFan ceilingFan;
    int previousSpeed;

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
    }

    @Override
    public void undo() {
        Utilities.setPreviousSpeed(ceilingFan,previousSpeed);
    }
}
