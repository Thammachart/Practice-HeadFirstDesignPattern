package org.remotetv;

import org.junit.Assert;
import org.junit.Test;

import org.remotetv.remote.*;
import org.remotetv.tv.*;

public class RemoteTest {

    @Test
    public void testSonyRemote() {
        TV tv = new SonyTV();
        RefinedRemote remote = new RefinedRemote(tv);

        testRemote(remote);
    }

    @Test
    public void testPhillipsRemote() {
        TV tv = new PhillipsTV();
        RefinedRemote remote = new RefinedRemote(tv);

        testRemote(remote);
    }

    private void testRemote(RefinedRemote remote) {
        remote.on();
        remote.setChannel(1);
        remote.setChannel(2);
        remote.nextChannel();
        remote.previousChannel();
        remote.off();
    }
}
