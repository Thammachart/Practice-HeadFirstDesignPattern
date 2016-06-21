package org.cd;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.net.URL;

import org.cd.proxy.image.ImageProxy;
import org.cd.states.NoImageState;

public class ImageProxyTestDrive {
    public static void main(String args[]) {
        URL url = null;

        try {
            url = new URL("https://static.pexels.com/photos/3247/nature-forest-industry-rails.jpg");
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        JFrame frame = new JFrame("CD Cover Viewer");
        frame.setSize(NoImageState.DEFAULT_WIDTH + 200, NoImageState.DEFAULT_HEIGHT + 200);

        ImageProxy imageProxy = new ImageProxy(url);
        JLabel label = new JLabel(imageProxy);
        label.setBounds(10,10,NoImageState.DEFAULT_WIDTH, NoImageState.DEFAULT_HEIGHT);

        frame.setLayout(null);
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
