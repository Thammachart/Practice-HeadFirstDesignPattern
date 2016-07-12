package org.dj.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.dj.models.BeatModelInterface;

public class DJOutputView implements ActionListener, BeatObserver, BPMObserver {
    private BeatModelInterface model;
    private ControllerInterface controller;
    private JFrame viewFrame;
    private JPanel viewPanel;
    private BeatBar beatBar;
    private JLabel bpmOutputLabel;

    public DJOutputView(ControllerInterface controller, BeatModelInterface model) {
        this.controller = controller;
        this.model = model;

        model.registerBeatObserver(this);
        model.registerBPMObserver(this);
    }

    public void createView() {
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("DJ Output View");

        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);

        beatBar = new BeatBar();
        beatBar.setValue(0);

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
    public void actionPerformed(ActionEvent event) {
        // TODO: actionPerformed
    }

    @Override
    public void updateBPM() {
        int bpm = model.getBPM();
        if(bpm == 0) {
            bpmOutputLabel.setText("offline");
        } else {
            bpmOutputLabel.setText("Current BPM: " + model.getBPM());
        }
    }

    @Override
    public void updateBeat() {
        beatBar.setValue(100);
    }
}
