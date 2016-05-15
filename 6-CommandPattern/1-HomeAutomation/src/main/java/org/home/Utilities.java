package org.home;

import org.home.device.CeilingFan;

public final class Utilities {
    public static void setPreviousSpeed(CeilingFan ceilingFan, int previousSpeed) {
        if(previousSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if(previousSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if(previousSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if(previousSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
