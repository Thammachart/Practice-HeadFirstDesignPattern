package org.dj;

import org.dj.models.HeartModel;
import org.dj.controllers.*;

public class MainClassHeart {
    public static void main(String args[]) {
        HeartModel heartModel = new HeartModel();
        ControllerInterface control = new HeartControlController(heartModel);
        ControllerInterface output = new HeartOutputController(heartModel);
    }
}
