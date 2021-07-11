package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class studentHome {
    private JButton FILLUPSTUDENTDETAILSButton;
    private JButton STARTQUIZButton;
    private JButton EXITButton;
    private JPanel studentHomePanel;
    private JButton QUIZEINSTRUCTIONButton;
    private JFrame studentHomeFrame;

    public studentHome() {
        studentHomeFrame = new JFrame("Quiz Exam Management System");
        studentHomeFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        studentHomeFrame.setPreferredSize(new Dimension(600, 500));
        studentHomeFrame.setResizable(true);

        studentHomeFrame.add(studentHomePanel);

        studentHomeFrame.pack();
        studentHomeFrame.setLocationRelativeTo(null);
        studentHomeFrame.setVisible(true);


        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Exit in this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                {
                    studentHomeFrame.dispose();
                    new index();
                }
            }
        });
        FILLUPSTUDENTDETAILSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentHomeFrame.dispose();
                new studentDetails();
            }
        });

        QUIZEINSTRUCTIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentHomeFrame.dispose();
                new quizInstructions();
            }
        });
        STARTQUIZButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentHomeFrame.dispose();
                new quizExam();
            }
        });
    }
}
