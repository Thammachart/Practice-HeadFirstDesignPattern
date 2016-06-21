package org.cd.states;

import java.awt.Component;
import java.awt.Graphics;

public interface State {

    int getIconWidth();
    int getIconHeight();
    void paintIcon(Component component, Graphics graphics, int x, int y);
}
