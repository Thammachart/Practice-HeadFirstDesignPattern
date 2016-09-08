package org.remotetv.remote;

import org.remotetv.tv.TV;

public class RefinedRemote extends Remote {
    private int currentChannel;

    public RefinedRemote(TV tv) {
        this.implementor = tv;
    }

    @Override
    public void setChannel(int channel) {
        this.currentChannel = channel;
        super.setChannel(channel);
    }

    public void nextChannel() {
        currentChannel++;
        setChannel(currentChannel);
    }

    public void previousChannel() {
        currentChannel--;
        setChannel(currentChannel);
    }
}
