package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class quizExam {

    public void studentRegistration(String reg_no, String name) {

        try {
            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "INSERT INTO `student_reg`(`roll_no`, `reg_no`, `stu_name`, 'result') VALUES (null,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            //preparedStatement.setString(1, String.valueOf(Integer.valueOf(roll_num)));
            preparedStatement.setString(1, reg_no);
            preparedStatement.setString(2, name);

            try {
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Your details successfully saved in to the system");

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());

            }
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());

        }
    }
    private JPanel quizExamPanel;
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
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JTextField textField11;
    private JComboBox comboBox11;
    private JButton SUBMITButton1;
    private JButton EXITButton1;
    private JTextField textField12;
    private JButton SAVEButton;
    private JTextField textField13;
    private JFrame quizExamFrame;

    public quizExam() {
        quizExamFrame = new JFrame("Quiz Exam Management System");
        quizExamFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        quizExamFrame.setPreferredSize(new Dimension(800, 800));
        quizExamFrame.setResizable(true);

        quizExamFrame.add(quizExamPanel);

        quizExamFrame.pack();
        quizExamFrame.setLocationRelativeTo(null);
        quizExamFrame.setVisible(true);


        EXITButton1.addActionListener(new ActionListener() {
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
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reg_no, name;
                JFrame msgFrame = new JFrame();

                reg_no= textField12.getText();
                name = textField13.getText();

                try{
                    studentRegistration(reg_no, name);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                textField12.setText("");
                textField13.setText("");



            }
        });
    }
}
