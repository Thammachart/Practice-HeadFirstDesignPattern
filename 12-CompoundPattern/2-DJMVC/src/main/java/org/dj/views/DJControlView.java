package org.dj.views;

import java.awt.event.*;
import javax.swing.*;

import org.dj.models.BeatModelInterface;

public class DJControlView implements BeatObserver, BPMObserver {
    private BeatModelInterface model;
    private ControllerInterface controller;
    private JLabel bpmLabel;
    private JTextField bpmTextField;
    private JButton setBPMButton;
    private JButton increaseBPMButton;
    private JButton decreaseBPMButton;
    private JMenuBar menuBar;

    // TODO: Implement your interfaces!
}
