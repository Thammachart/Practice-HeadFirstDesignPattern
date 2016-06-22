package org.cd.states;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class HasImageState implements State {
    private ImageIcon icon;

    public HasImageState(ImageIcon icon) {
        if(icon == null)
            throw new NullPointerException("Icon must not be null");

        this.icon = icon;
    }

    @Override
    public int getIconWidth() {
        return this.icon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return this.icon.getIconHeight();
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int x, int y) {
        this.icon.paintIcon(component, graphics, 10, 10);
    }
}
