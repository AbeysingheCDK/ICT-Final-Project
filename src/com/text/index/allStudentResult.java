package com.text.index;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class allStudentResult {

    public void showAllResults(){
        try {
            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "SELECT * FROM `student_result`";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);


            ResultSet resultSet = preparedStatement.executeQuery();

            table1.setModel(new DefaultTableModel(
                    null,
                    new String[] {"Roll Number", "Student Name", "Result"}
            ));
            while (resultSet.next()){
                String roll_num = resultSet.getString(1);
                String stu_name = resultSet.getString(2);
                String stu_result = resultSet.getString(3);

                String data[] = {roll_num, stu_name, stu_result};
                DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
                tableModel.addRow(data);
            }
            resultSet.close();
            preparedStatement.close();

        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,"Oops !!!\nSomething went Wrong !!!\n"+exception.getMessage());
        }
    }

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

        showAllResults();


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
