package org.dj.models;

import org.dj.views.BeatObserver;
import org.dj.views.BPMObserver;
import org.dj.models.HeartModelInterface;

public class HeartAsBeatModelAdapter implements BeatModelInterface {
    private HeartModelInterface heart;

    public HeartAsBeatModelAdapter(HeartModelInterface heart) {
        this.heart = heart;
    }

    @Override
    public void initialize() {}

    @Override
    public void on() {}

    @Override
    public void off() {}

    @Override
    public int getBPM() {
        return heart.getHeartRate();
    }

    @Override
    public void setBPM(int bpm) {}

    @Override
    public void registerBeatObserver(BeatObserver observer) {
        heart.registerBeatObserver(observer);
    }

    @Override
    public void removeBeatObserver(BeatObserver observer) {
        heart.removeBeatObserver(observer);
    }

    @Override
    public void registerBPMObserver(BPMObserver observer) {
        heart.registerBPMObserver(observer);
    }

    @Override
    public void removeBPMObserver(BPMObserver observer) {
        heart.removeBPMObserver(observer);
    }
}
