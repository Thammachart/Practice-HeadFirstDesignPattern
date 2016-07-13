package org.dj;

import org.dj.models.BeatModelInterface;
import org.dj.models.BeatModel;
import org.dj.controllers.*;

public class MainClass {
    public static void main(String args[]) {
        BeatModelInterface model = new BeatModel();
        BeatControlController control = new BeatControlController(model);
        BeatOutputController output = new BeatOutputController(model);
        model.initialize();
    }
}
