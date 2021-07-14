package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class quizPage {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTable table1;
    private JButton SUBMITButton;
    private JButton EXITButton;
    private JPanel quizPagePanel;
    private JFrame quizPageFrame;


    public quizPage() {


        quizPageFrame = new JFrame("Quiz Exam Management System");
        quizPageFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        quizPageFrame.setPreferredSize(new Dimension(600, 500));
        quizPageFrame.setResizable(true);

        quizPageFrame.add(quizPagePanel);

        quizPageFrame.pack();
        quizPageFrame.setLocationRelativeTo(null);
        quizPageFrame.setVisible(true);


        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Exit in this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                {
                    quizPageFrame.dispose();
                    new studentHome();
                }

            }
        });
    }
}
