package org.question;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainForm extends JFrame {
    private JButton questionBtn;

    public MainForm() {
        questionBtn = new JButton();
        questionBtn.setText("Should I do it?");
        questionBtn.addActionListener((event) -> System.out.println("Don't Do it"));
        questionBtn.addActionListener((event) -> System.out.println("Come on, do it!"));
        this.getContentPane().add(questionBtn);

        initializeForm();
    }

    private void initializeForm() {
        this.setTitle("The Question!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200,200);
        this.setVisible(true);
    }
}
