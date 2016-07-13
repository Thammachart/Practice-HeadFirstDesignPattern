package org.dj.controllers;

import org.dj.models.HeartAsBeatModelAdapter;
import org.dj.models.HeartModelInterface;
import org.dj.views.DJOutputView;

public class HeartOutputController implements ControllerInterface {
    private HeartModelInterface model;
    private DJOutputView view;

    public HeartOutputController(HeartModelInterface model) {
        this.model = model;

        view = new DJOutputView(new HeartAsBeatModelAdapter(model));
        view.createView();
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
