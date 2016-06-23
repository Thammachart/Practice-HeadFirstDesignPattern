package org.cd.actions;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.net.URL;

import org.cd.proxy.image.ImageProxy;

public class MenuActionListener implements ActionListener {
    private Component component;
    private ImageProxy imageProxy;
    private URL url;

    public MenuActionListener(Component component, ImageProxy imageProxy, URL url) {
        this.imageProxy = imageProxy;
        this.url = url;
        this.component = component;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.imageProxy.setURL(url);
        component.repaint();
    }
}
