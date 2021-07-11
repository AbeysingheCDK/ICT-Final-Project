package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frontWindow {
    private JButton letSGoButton;
    private JPanel frontWindowPanel;
    private JFrame frontWindowFrame;


    public frontWindow() {
        frontWindowFrame = new JFrame("Quiz Exam Management System");
        frontWindowFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frontWindowFrame.setPreferredSize(new Dimension(600, 500));
        frontWindowFrame.setResizable(true);

        frontWindowFrame.add(frontWindowPanel);

        frontWindowFrame.pack();
        frontWindowFrame.setLocationRelativeTo(null);
        frontWindowFrame.setVisible(true);

        letSGoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frontWindowFrame.dispose();
                new index();


            }
        });
    }
}
