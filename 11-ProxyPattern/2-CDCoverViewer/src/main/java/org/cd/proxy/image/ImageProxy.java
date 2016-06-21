package org.cd.proxy.image;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import java.net.URL;

import org.cd.states.*;

public class ImageProxy implements Icon {
    private final URL imageURL;
    private Thread retrivalThread;
    private boolean retrieving;

    private State currentState;

    private static int DEFAULT_HEIGHT = 600;
    private static int DEFAULT_WIDTH = 800;

    public ImageProxy(URL url) {
        this.retrieving = false;
        this.imageURL = url;

        this.currentState = new NoImageState(this);
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public URL getURL() {
        return imageURL;
    }

    @Override
    public int getIconWidth() {
        return this.currentState.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return this.currentState.getIconHeight();
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int x, int y) {
        this.currentState.paintIcon(component, graphics, x, y);
    }
}
