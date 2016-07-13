package org.dj.controllers;

import org.dj.views.DJOutputView;
import org.dj.models.BeatModelInterface;

public class BeatOutputController {
    private DJOutputView outputView;

    public BeatOutputController(BeatModelInterface model) {
        outputView = new DJOutputView(model);
        outputView.createView();
    }
}
