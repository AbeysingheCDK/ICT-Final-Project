package com.text.index;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class studentHome extends myFrameset{
    private JButton FILLUPSTUDENTDETAILSButton;
    private JButton STARTQUIZButton;
    private JButton EXITButton;
    private JPanel studentHomePanel;
    private JButton QUIZEINSTRUCTIONButton;
    private JFrame studentHomeFrame = null;

    public studentHome() {
        studentHomeFrame = setFrame(studentHomePanel, studentHomeFrame);

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
                new quizPage();
            }
        });
    }
}
