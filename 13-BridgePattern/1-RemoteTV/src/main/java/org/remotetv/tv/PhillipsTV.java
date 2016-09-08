package org.remotetv.tv;

public class PhillipsTV implements TV {
    @Override
    public void on() {
        System.out.println("Phillips TV is on");
    }

    @Override
    public void off() {
        System.out.println("Phillips TV is off");
    }

    @Override
    public void tuneChannel(int channel) {
        System.out.println("Phillips TV Channel is tuned to " + channel);
    }
}
