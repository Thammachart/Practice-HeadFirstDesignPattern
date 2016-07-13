package org.dj.controllers;

import org.dj.views.DJControlView;
import org.dj.models.BeatModelInterface;

public class BeatControlController implements ControllerInterface {
    private BeatModelInterface model;
    private DJControlView controlView;

    public BeatControlController(BeatModelInterface model) {
        this.model = model;

        controlView = new DJControlView(this, model);
        controlView.createView();
        controlView.disableStopMenuItem();
        controlView.enableStartMenuItem();
    }

    @Override
    public void start() {
        model.on();
        controlView.disableStartMenuItem();
        controlView.enableStopMenuItem();
    }

    @Override
    public void stop() {
        model.off();
        controlView.disableStopMenuItem();
        controlView.enableStartMenuItem();
    }

    @Override
    public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
    }

    @Override
    public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
    }

    @Override
    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }
}
