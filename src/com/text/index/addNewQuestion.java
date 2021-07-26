package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class addNewQuestion {

    public void studentRegistration(int questionID, String question, String option1, String option2, String option3, String option4, String answer ){

        try{
            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "INSERT INTO `all_questions` (`questionID`, `question`, `option1`, `option2`, `option3`, `option4`, `answer`) VALUES (NULL, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            //preparedStatement.setString(1, String.valueOf(Integer.valueOf(roll_num)));
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, option1);
            preparedStatement.setString(3, option2);
            preparedStatement.setString(4, option3);
            preparedStatement.setString(5, option4);
            preparedStatement.setString(6, answer);


            try{
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "New questions successfully added to the system");

            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());

            }
            connection.close();
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());

        }
    }

    private JLabel addNewQuestion;
    private JButton exitButton;
    private JButton SAVEButton;
    private JTextField a00TextField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JPanel addNewQuestionPanel;
    private JFrame addNewQuestionFrame;


    public addNewQuestion() {
        addNewQuestionFrame = new JFrame("Quiz Exam Management System");
        addNewQuestionFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addNewQuestionFrame.setPreferredSize(new Dimension(1500, 1000));
        addNewQuestionFrame.setResizable(true);

        addNewQuestionFrame.add(addNewQuestionPanel);

        addNewQuestionFrame.pack();
        addNewQuestionFrame.setLocationRelativeTo(null);
        addNewQuestionFrame.setVisible(true);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout from this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                addNewQuestionFrame.dispose();
                new adminHome();

            }
        });
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String question, opt1, opt2, opt3, opt4, answer;

                int questionID;
                JFrame msgFrame = new JFrame();

                questionID = Integer.parseInt(a00TextField.getText());
                question = textField2.getText();
                opt1 = textField3.getText();
                opt2 = textField4.getText();
                opt3 = textField5.getText();
                opt4 = textField6.getText();
                answer = textField7.getText();

                try{
                    studentRegistration(questionID, question, opt1, opt2, opt3, opt4, answer);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                a00TextField.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");



            }
        });
    }
}
