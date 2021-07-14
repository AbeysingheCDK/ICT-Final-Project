package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class studentDetails {

    public void studentRegistration(String reg_no, String name, String address, String con_number, String gender, String email ){

        try{
            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "INSERT INTO `student_reg`(`roll_no`, `reg_no`, `stu_name`, `address`, `tp`, `gender`, `email`) VALUES (null,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            //preparedStatement.setString(1, String.valueOf(Integer.valueOf(roll_num)));
            preparedStatement.setString(1, reg_no);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, con_number);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, email);


            try{
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Your details successfully saved in to the system");

            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());

            }
            connection.close();
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());

        }
    }

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
                    new studentHome();
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
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String reg_no, name, address, con_number, gender, email;
                int roll_num;
                JFrame msgFrame = new JFrame();

                reg_no= textField1.getText();
                name = textField2.getText();
                address = textField3.getText();
                con_number = textField4.getText();
                gender = comboBox1.getSelectedItem().toString();
                email = textField5.getText();

                try{
                    studentRegistration(reg_no, name, address, con_number, gender, email);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                comboBox1.setSelectedItem("");
                textField5.setText("");


            }
        });
    }
}
