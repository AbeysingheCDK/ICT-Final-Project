package com.text.index;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminHome extends myFrameset{
    private JButton addNewQuestionButton;
    private JButton updateQuestionButton;
    private JButton allQuestionButton;
    private JButton deleteQuestionButton;
    private JButton allStudentResultsButton;
    private JButton logoutButton;
    private JButton exitButton;
    private JPanel adminHomePanel;
    private JFrame adminHomeFrame = null;


    public adminHome() {
        adminHomeFrame = setFrame(adminHomePanel, adminHomeFrame);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout from this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                {
                    adminHomeFrame.dispose();
                    new loginAdmin();
                }


            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Exit in this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                {
                    adminHomeFrame.dispose();
                    new index();
                }

            }
        });
        addNewQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminHomeFrame.dispose();
                new addNewQuestion();
            }
        });
        updateQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminHomeFrame.dispose();
                new updateQuestion();
            }
        });
        allQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminHomeFrame.dispose();
                new allQuestions();
            }
        });
        deleteQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminHomeFrame.dispose();
                new deleteQuestions();
            }
        });
        allStudentResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminHomeFrame.dispose();
                new allStudentResult();
            }
        });
    }
}
