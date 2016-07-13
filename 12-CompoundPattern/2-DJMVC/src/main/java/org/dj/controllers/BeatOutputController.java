package org.dj.controllers;

import org.dj.views.DJOutputView;
import org.dj.models.BeatModelInterface;

public class BeatOutputController implements ControllerInterface {
    private DJOutputView outputView;

    public BeatOutputController(BeatModelInterface model) {
        outputView = new DJOutputView(model);
        outputView.createView();
    }

    @Override
    public void start() {}

    @Override
    public void stop() {}

    @Override
    public void increaseBPM() {}

    @Override
    public void decreaseBPM() {}

    @Override
    public void setBPM(int bpm) {}
}
