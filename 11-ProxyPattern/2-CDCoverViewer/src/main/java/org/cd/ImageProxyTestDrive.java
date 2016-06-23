package org.cd;

import javax.swing.JFrame;

public class ImageProxyTestDrive {

    public static void main(String args[]) {
        JFrame frame = initializeFrame();
        frame.setVisible(true);
    }

    private static JFrame initializeFrame() {
        JFrame frame = new ImageFrame();
        return frame;
    }

}
