package com.text.index;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class quizPage {

    public void showAllQuestions(){
        try {
            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "SELECT * FROM `all_questions`";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);


            ResultSet resultSet = preparedStatement.executeQuery();

            table1.setModel(new DefaultTableModel(
                    null,
                    new String[] {"questionID", "question", "option1", "option2", "option3", "option4"}
            ));
            while (resultSet.next()){
                String queID = resultSet.getString(1);
                String ques = resultSet.getString(2);
                String opt1 = resultSet.getString(3);
                String opt2 = resultSet.getString(4);
                String opt3 = resultSet.getString(5);
                String opt4 = resultSet.getString(6);


                String data[] = {queID, ques, opt1, opt2, opt3, opt4};
                DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
                tableModel.addRow(data);
            }
            resultSet.close();
            preparedStatement.close();

        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,"Oops !!!\nSomething went Wrong !!!\n"+exception.getMessage());
        }
    }


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
        quizPageFrame.setPreferredSize(new Dimension(700, 700));
        quizPageFrame.setResizable(true);

        quizPageFrame.add(quizPagePanel);

        quizPageFrame.pack();
        quizPageFrame.setLocationRelativeTo(null);
        quizPageFrame.setVisible(true);

        showAllQuestions();


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
        SUBMITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
