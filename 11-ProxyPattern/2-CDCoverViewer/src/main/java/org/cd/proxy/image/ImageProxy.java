package org.cd.proxy.image;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.net.URL;

public class ImageProxy implements Icon {
    private volatile ImageIcon imageIcon;
    private final URL imageURL;
    private Thread retrivalThread;
    private boolean retrieving;

    private static int DEFAULT_HEIGHT = 600;
    private static int DEFAULT_WIDTH = 800;

    public ImageProxy(URL url) {
        this.retrieving = false;
        this.imageURL = url;
    }

    @Override
    public int getIconWidth() {
        if(imageIcon != null)
            return imageIcon.getIconWidth();

        return DEFAULT_WIDTH;
    }

    @Override
    public int getIconHeight() {
        if(imageIcon != null)
            return imageIcon.getIconHeight();

        return DEFAULT_HEIGHT;
    }

    private synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int x, int y) {
        if(imageIcon != null) {
            imageIcon.paintIcon(component,graphics,x,y);
        } else {
            graphics.drawString("Loading CD Cover, please wait...", x+300, y+190);
            startLoadingImage(component);
        }
    }

    private void startLoadingImage(Component component) {
        if(!retrieving) {
            retrieving = true;

            retrivalThread = new Thread(() -> {
                try {
                    setImageIcon(new ImageIcon(imageURL, "CD Cover"));
                    component.repaint();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            });
            retrivalThread.start();
        }
    }
}
