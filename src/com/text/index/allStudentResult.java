package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class allStudentResult {
    private JTable table1;
    private JButton EXITButton;
    private JPanel allStudentResultPanel;
    private JFrame allStudentResultFrame;

    public allStudentResult() {
        allStudentResultFrame = new JFrame("Quiz Exam Management System");
        allStudentResultFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        allStudentResultFrame.setPreferredSize(new Dimension(600, 500));
        allStudentResultFrame.setResizable(true);

        allStudentResultFrame.add(allStudentResultPanel);

        allStudentResultFrame.pack();
        allStudentResultFrame.setLocationRelativeTo(null);
        allStudentResultFrame.setVisible(true);


        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout from this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                    allStudentResultFrame.dispose();
                new adminHome();

            }
        });
    }
}
