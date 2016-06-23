package org.cd;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.net.URL;

import org.cd.proxy.image.ImageProxy;
import org.cd.states.NoImageState;
import org.cd.actions.MenuActionListener;

public class ImageFrame extends JFrame {

    private ImageProxy imageProxy;
    private JLabel label;
    private URL urls[];

    private JMenuBar menuBar;

    public ImageFrame() {
        super("CD Cover Viewer");

        this.initializeJFrame();

        this.initializeURLs();

        this.initializeImageLabel();

        this.initializeMenuBar();
    }

    private void initializeJFrame() {
        this.setSize(NoImageState.DEFAULT_WIDTH + 200, NoImageState.DEFAULT_HEIGHT + 200);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private URL[] initializeURLs() {
        try {
            urls = new URL[] {
                new URL("http://www.iworkscorp.com/wp-content/uploads/2015/05/200x100.gif"),
                new URL("http://authentic-scandinavia.com/system/images/tours/photos/155/thumbnail.jpg"),
                new URL("http://megaicons.net/static/img/icons_sizes/8/178/256/industry-factory-icon.png"),
                new URL("https://pbs.twimg.com/profile_images/622434747759882241/ySLNqJ_O.png"),
                new URL("http://suptg.thisisnotatrueending.com/archive/12854719/images/1290187623421.jpg")
            };

            return urls;
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("One of URls is broken");
        }
    }

    private void initializeImageLabel() {
        this.imageProxy = new ImageProxy(urls[0]);
        label = new JLabel(imageProxy);
        label.setBounds(10,10,NoImageState.DEFAULT_WIDTH, NoImageState.DEFAULT_HEIGHT);
        this.add(label);
    }

    private JMenuBar initializeMenuBar() {
        menuBar = new JMenuBar();

        JMenu menu = new JMenu("CD Cover");
        menuBar.add(menu);

        for (int i=0; i < urls.length; i++) {
            JMenuItem menuItem = new JMenuItem("Item " + (i+1));
            menuItem.addActionListener(new MenuActionListener(this.label, imageProxy, urls[i]));
            menu.add(menuItem);
        }

        this.setJMenuBar(menuBar);

        return menuBar;
    }


}
