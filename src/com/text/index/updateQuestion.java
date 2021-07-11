package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateQuestion {
    private JButton exitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton searchButton;
    private JButton UPDATEButton;
    private JButton CLEARButton;
    private JPanel updateQuestionPanel;
    private JFrame updateQuestionFrame;


    public updateQuestion() {
        updateQuestionFrame = new JFrame("Quiz Exam Management System");
        updateQuestionFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        updateQuestionFrame.setPreferredSize(new Dimension(600, 500));
        updateQuestionFrame.setResizable(true);

        updateQuestionFrame.add(updateQuestionPanel);

        updateQuestionFrame.pack();
        updateQuestionFrame.setLocationRelativeTo(null);
        updateQuestionFrame.setVisible(true);


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout from this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                    updateQuestionFrame.dispose();
                new adminHome();

            }
        });
    }
}
