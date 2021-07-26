package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class deleteQuestions {

    public void searchQuestion(String queID) throws Exception {

        try {
            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "SELECT * FROM all_questions WHERE questionID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, queID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                textField1.setText(resultSet.getString(1));
                textField2.setText(resultSet.getString(2));
                textField3.setText(resultSet.getString(3));
                textField4.setText(resultSet.getString(4));
                textField5.setText(resultSet.getString(5));
                textField6.setText(resultSet.getString(6));
                textField7.setText(resultSet.getString(7));
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteQuestion(String questionID) {

        try {
            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "DELETE FROM all_questions where  questionID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, questionID);


            try {
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Selected question successfully deleted from the system");

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());

            }
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());


        }
    }

    private JButton exitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField7;
    private JTextField textField6;
    private JButton searchButton;
    private JButton DELETEButton;
    private JPanel deleteQuestionPanel;
    private JFrame deleteQuestionFrame;


    public deleteQuestions() {
        deleteQuestionFrame = new JFrame("Quiz Exam Management System");
        deleteQuestionFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        deleteQuestionFrame.setPreferredSize(new Dimension(1500, 1000));
        deleteQuestionFrame.setResizable(true);

        deleteQuestionFrame.add(deleteQuestionPanel);

        deleteQuestionFrame.pack();
        deleteQuestionFrame.setLocationRelativeTo(null);
        deleteQuestionFrame.setVisible(true);


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout from this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                    deleteQuestionFrame.dispose();
                new adminHome();

            }
        });


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String queID = textField1.getText();

                try {
                    searchQuestion(queID);


                } catch (Exception exception) {
                    exception.printStackTrace();
                }


            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String questionID =textField1.getText();

                try {
                    deleteQuestion(questionID);


                } catch (Exception exception) {
                    exception.printStackTrace();
                }


            }
        });
    }
}

