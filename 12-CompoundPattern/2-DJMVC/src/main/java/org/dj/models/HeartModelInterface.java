package org.dj.models;

import org.dj.views.BeatObserver;
import org.dj.views.BPMObserver;

public interface HeartModelInterface {
    int getHeartRate();
    void registerBeatObserver(BeatObserver observer);
    void removeBeatObserver(BeatObserver observer);
    void registerBPMObserver(BPMObserver observer);
    void removeBPMObserver(BPMObserver observer);
}
