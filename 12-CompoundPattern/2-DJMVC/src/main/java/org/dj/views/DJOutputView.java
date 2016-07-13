package org.dj.views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.dj.models.BeatModelInterface;

public class DJOutputView implements BeatObserver, BPMObserver {
    private BeatModelInterface model;
    private JFrame viewFrame;
    private JPanel viewPanel;
    private BeatBar beatBar;
    private JLabel bpmOutputLabel;

    public DJOutputView(BeatModelInterface model) {
        this.model = model;

        model.registerBeatObserver(this);
        model.registerBPMObserver(this);
    }

    public void createView() {
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("DJ Output View");

        bpmOutputLabel = new JLabel("Offline", SwingConstants.CENTER);

        beatBar = new BeatBar();
        beatBar.setValue(50);

        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);

        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);

        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(100, 80);

        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    @Override
    public void updateBPM() {
        if(model != null) {
            int bpm = model.getBPM();
            if(bpm == 0) {
                bpmOutputLabel.setText("Offline");
            } else {
                bpmOutputLabel.setText("Current BPM: " + model.getBPM());
            }
        }
    }

    @Override
    public void updateBeat() {
        if(beatBar != null) {
            beatBar.setValue(100);
        }
    }
}
