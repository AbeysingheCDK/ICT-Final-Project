package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addNewQuestion {
    private JLabel addNewQuestion;
    private JButton exitButton;
    private JButton SAVEButton;
    private JButton CLEARButton;
    private JTextField a00TextField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JPanel addNewQuestionPanel;
    private JFrame addNewQuestionFrame;


    public addNewQuestion() {
        addNewQuestionFrame = new JFrame("Quiz Exam Management System");
        addNewQuestionFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addNewQuestionFrame.setPreferredSize(new Dimension(600, 500));
        addNewQuestionFrame.setResizable(true);

        addNewQuestionFrame.add(addNewQuestionPanel);

        addNewQuestionFrame.pack();
        addNewQuestionFrame.setLocationRelativeTo(null);
        addNewQuestionFrame.setVisible(true);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout from this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                addNewQuestionFrame.dispose();
                new adminHome();

            }
        });
    }
}
