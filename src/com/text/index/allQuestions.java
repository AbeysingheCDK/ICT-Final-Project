package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class allQuestions {
    private JButton exitButton;
    private JPanel allQuestionsPanel;
    private JTable table1;
    private JFrame allQuestionsFrame;


    public allQuestions() {
        allQuestionsFrame = new JFrame("Quiz Exam Management System");
        allQuestionsFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        allQuestionsFrame.setPreferredSize(new Dimension(600, 500));
        allQuestionsFrame.setResizable(true);

        allQuestionsFrame.add(allQuestionsPanel);

        allQuestionsFrame.pack();
        allQuestionsFrame.setLocationRelativeTo(null);
        allQuestionsFrame.setVisible(true);


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout from this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                    allQuestionsFrame.dispose();
                new adminHome();

            }
        });
    }
}
