package com.text.index;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class allQuestions {

    public void showAllQuestions(){
        try {
            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "SELECT * FROM `all_questions`";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);


            ResultSet resultSet = preparedStatement.executeQuery();

            table1.setModel(new DefaultTableModel(
                    null,
                    new String[] {"questionID", "question", "option1", "option2", "option3", "option4", "answer"}
            ));
            while (resultSet.next()){
                String queID = resultSet.getString(1);
                String ques = resultSet.getString(2);
                String opt1 = resultSet.getString(3);
                String opt2 = resultSet.getString(4);
                String opt3 = resultSet.getString(5);
                String opt4 = resultSet.getString(6);
                String answer = resultSet.getString(7);


                String data[] = {queID, ques, opt1, opt2, opt3, opt4, answer};
                DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
                tableModel.addRow(data);
            }
            resultSet.close();
            preparedStatement.close();

        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,"Oops !!!\nSomething went Wrong !!!\n"+exception.getMessage());
        }
    }


    private JButton exitButton;
    private JPanel allQuestionsPanel;
    private JTable table1;
    private JFrame allQuestionsFrame;


    public allQuestions() {

        allQuestionsFrame = new JFrame("Quiz Exam Management System");
        allQuestionsFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        allQuestionsFrame.setPreferredSize(new Dimension(600, 500));
        allQuestionsFrame.setResizable(true);

        allQuestionsFrame.add(allQuestionsPanel);

        allQuestionsFrame.pack();
        allQuestionsFrame.setLocationRelativeTo(null);
        allQuestionsFrame.setVisible(true);

        showAllQuestions();

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout from this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                    allQuestionsFrame.dispose();
                new adminHome();

            }
        });
    }
}
