package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteQuestions {
    private JButton exitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField7;
    private JTextField textField6;
    private JButton searchButton;
    private JButton DELETEButton;
    private JButton CLEARButton;
    private JPanel deleteQuestionPanel;
    private JFrame deleteQuestionFrame;


    public deleteQuestions() {
        deleteQuestionFrame = new JFrame("Quiz Exam Management System");
        deleteQuestionFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        deleteQuestionFrame.setPreferredSize(new Dimension(600, 500));
        deleteQuestionFrame.setResizable(true);

        deleteQuestionFrame.add(deleteQuestionPanel);

        deleteQuestionFrame.pack();
        deleteQuestionFrame.setLocationRelativeTo(null);
        deleteQuestionFrame.setVisible(true);


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout from this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                    deleteQuestionFrame.dispose();
                new adminHome();

            }
        });
    }
}
