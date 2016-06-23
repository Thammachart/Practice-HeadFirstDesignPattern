package org.cd.proxy.image;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import java.net.URL;

import org.cd.states.*;

public class ImageProxy implements Icon {
    private Thread retrivalThread;
    private boolean retrieving;

    private URL url;

    private State currentState;

    private static int DEFAULT_HEIGHT = 600;
    private static int DEFAULT_WIDTH = 800;

    public ImageProxy(URL defaultURL) {
        this.retrieving = false;
        this.url = defaultURL;

        setURL(defaultURL);
    }

    public URL getURL() {
        return this.url;
    }

    public void setURL(URL url) {
        this.url = url;
        setState(new NoImageState(this));
    }

    public void setState(State state) {
        this.currentState = state;
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
