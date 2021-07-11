package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class studentDetails {
    private JButton BACKButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JComboBox comboBox1;
    private JTextField textField6;
    private JButton SAVEButton;
    private JButton NEXTButton;
    private JPanel studentDetailsPanel;
    private JFrame studentDetailsFrame;


    public studentDetails() {
        studentDetailsFrame = new JFrame("Quiz Exam Management System");
        studentDetailsFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        studentDetailsFrame.setPreferredSize(new Dimension(600, 500));
        studentDetailsFrame.setResizable(true);

        studentDetailsFrame.add(studentDetailsPanel);

        studentDetailsFrame.pack();
        studentDetailsFrame.setLocationRelativeTo(null);
        studentDetailsFrame.setVisible(true);

        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Exit in this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                {
                    studentDetailsFrame.dispose();
                    new index();
                }

            }
        });


        NEXTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentDetailsFrame.dispose();
                new studentHome();
            }
        });
    }
}
