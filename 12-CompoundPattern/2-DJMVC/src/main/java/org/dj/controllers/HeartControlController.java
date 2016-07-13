package org.dj.controllers;

import org.dj.models.HeartAsBeatModelAdapter;
import org.dj.models.HeartModelInterface;
import org.dj.views.DJControlView;

public class HeartControlController implements ControllerInterface {
    private HeartModelInterface model;
    private DJControlView view;

    public HeartControlController(HeartModelInterface model) {
        this.model = model;
        view = new DJControlView(this, new HeartAsBeatModelAdapter(model));
        view.createView();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
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
