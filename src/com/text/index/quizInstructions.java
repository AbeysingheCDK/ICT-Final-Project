package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quizInstructions {
    private JButton EXITButton;
    private JPanel quizInstructionPanel;
    private JFrame quizInstructionFrame;

    public quizInstructions() {
        quizInstructionFrame = new JFrame("Quiz Exam Management System");
        quizInstructionFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        quizInstructionFrame.setPreferredSize(new Dimension(1500, 1000));
        quizInstructionFrame.setResizable(true);

        quizInstructionFrame.add(quizInstructionPanel);

        quizInstructionFrame.pack();
        quizInstructionFrame.setLocationRelativeTo(null);
        quizInstructionFrame.setVisible(true);

        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Exit in this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                {
                    quizInstructionFrame.dispose();
                    new studentHome();
                }

            }
        });
    }
}
