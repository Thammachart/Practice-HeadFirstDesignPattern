package org.cd.states;

import java.awt.Component;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.net.URL;

import org.cd.proxy.image.ImageProxy;

public class NoImageState implements State {
    public static final int DEFAULT_HEIGHT = 400;
    public static final int DEFAULT_WIDTH = 400;

    private ImageProxy imageProxy;

    private Object lockObject = new Object();

    public NoImageState(ImageProxy imageProxy) {
        this.imageProxy = imageProxy;
    }

    @Override
    public int getIconWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    public int getIconHeight() {
        return DEFAULT_HEIGHT;
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int x, int y) {
        graphics.drawString("Loading CD Cover, please wait...", x+10, y+10);
        startLoadingImage(component);
    }

    private void startLoadingImage(Component component) {
        synchronized(lockObject) {
            Thread retrivalThread = new Thread(() -> {
                try {
                    ImageIcon icon = new ImageIcon(ImageIO.read(imageProxy.getURL()), "CD Cover");

                    imageProxy.setState(new HasImageState(icon));

                    component.repaint();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            });
            retrivalThread.start();
        }
    }
}
