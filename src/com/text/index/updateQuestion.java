package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class updateQuestion {

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

    public void updateQuestion( int questionID, String question, String opt1, String opt2, String opt3, String opt4, String answer){

        try{
            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "UPDATE all_questions SET question = ?, option1 = ?, option2 =?, option3 =?, option4 = ? , answer = ? WHERE questionID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, opt1);
            preparedStatement.setString(3, opt2);
            preparedStatement.setString(4, opt3);
            preparedStatement.setString(5, opt4);
            preparedStatement.setString(6, answer);
            preparedStatement.setString(7, String.valueOf(questionID));

            try{
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Updated question successfully saved in to the system");

            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());

            }
            connection.close();
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());


        }
    }
    private JButton exitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton searchButton;
    private JButton UPDATEButton;
    private JPanel updateQuestionPanel;
    private JFrame updateQuestionFrame;


    public updateQuestion() {
        updateQuestionFrame = new JFrame("Quiz Exam Management System");
        updateQuestionFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        updateQuestionFrame.setPreferredSize(new Dimension(700, 700));
        updateQuestionFrame.setResizable(true);

        updateQuestionFrame.add(updateQuestionPanel);

        updateQuestionFrame.pack();
        updateQuestionFrame.setLocationRelativeTo(null);
        updateQuestionFrame.setVisible(true);


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout from this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                    updateQuestionFrame.dispose();
                new adminHome();

            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String question, opt1, opt2, opt3, opt4, answer;
                int questionID;
                JFrame msgFrame = new JFrame();

                questionID = Integer.parseInt(textField1.getText());
                question = textField2.getText();
                opt1 = textField3.getText();
                opt2 = textField4.getText();
                opt3 = textField5.getText();
                opt4 = textField6.getText();
                answer = textField7.getText();

                try{
                    updateQuestion(questionID, question, opt1, opt2, opt3, opt4, answer);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String queID = textField1.getText();

                try {
                    searchQuestion(queID);


                }catch (Exception exception) {
                    exception.printStackTrace();
                }


            }
        });
    }
}
