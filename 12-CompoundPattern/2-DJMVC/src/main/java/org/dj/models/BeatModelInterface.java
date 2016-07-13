package org.dj.models;

import org.dj.views.BeatObserver;
import org.dj.views.BPMObserver;

public interface BeatModelInterface {
    void initialize();

    void on();

    void off();

    void setBPM(int bpm);

    int getBPM();

    void registerBeatObserver(BeatObserver observer);

    void removeBeatObserver(BeatObserver observer);

    void registerBPMObserver(BPMObserver observer);

    void removeBPMObserver(BPMObserver observer);
}
