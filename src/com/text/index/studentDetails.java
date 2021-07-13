package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class studentDetails {

    public void studentRegistration(int roll_num, String first_name, String name_initials, String address, String con_number, String gender, String email ){

        try{
            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "INSERT INTO `student` (`roll_no`, `first_name`, `name_with_initials`, `address`, `contact_number`, `gender`, `email`) VALUES (NULL, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            //preparedStatement.setString(1, String.valueOf(Integer.valueOf(roll_num)));
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, name_initials);
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
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String first_name, name_initials, address, con_number, gender, email;
                int roll_num;
                JFrame msgFrame = new JFrame();

                roll_num = Integer.parseInt(textField1.getText());
                first_name = textField2.getText();
                name_initials = textField3.getText();
                address = textField4.getText();
                con_number = textField5.getText();
                gender = comboBox1.getSelectedItem().toString();
                email = textField6.getText();

                try{
                    studentRegistration(roll_num, first_name, name_initials, address, con_number, gender, email);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                comboBox1.setSelectedItem("");
                textField6.setText("");

            }
        });
    }
}
