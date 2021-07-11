package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quizExam {
    private JButton EXITButton;
    private JButton SUBMITButton;
    private JPanel quizExamPanel;
    private JFrame quizExamFrame;

    public quizExam() {
        quizExamFrame = new JFrame("Quiz Exam Management System");
        quizExamFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        quizExamFrame.setPreferredSize(new Dimension(600, 500));
        quizExamFrame.setResizable(true);

        quizExamFrame.add(quizExamPanel);

        quizExamFrame.pack();
        quizExamFrame.setLocationRelativeTo(null);
        quizExamFrame.setVisible(true);

        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Exit in this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                {
                    quizExamFrame.dispose();
                    new studentHome();
                }

            }
        });

    }
}
