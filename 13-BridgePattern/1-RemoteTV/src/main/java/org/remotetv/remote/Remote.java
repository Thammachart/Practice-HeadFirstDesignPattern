package org.remotetv.remote;

import org.remotetv.tv.TV;

public abstract class Remote {
    protected TV implementor;

    public void on() {
        implementor.on();
    }

    public void off() {
        implementor.off();
    }

    public void setChannel(int channel) {
        implementor.tuneChannel(channel);
    }
}
