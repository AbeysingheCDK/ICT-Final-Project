package com.text.index;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class quizPage extends myFrameset{

    String stu_answers[] = new String[10];
    int correct_answers = 0;
    String result[] = new String[10];
    String quizAnswers[] = new String[10];
    String reg_no;


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

    public void getAnswers(){

        try {

            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "SELECT answer FROM all_questions";

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sqlQuery);
            //System.out.println(resultSet);

            int i = 0;

            while (resultSet.next()) {
                String  stu_result = resultSet.getString("answer");

                //System.out.println(stu_result);

            quizAnswers[i] = stu_result;
            i += 1;

            }

            resultSet.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void checkAnswer(String id, String stuAnswer) {

        int convert_id =  Integer. parseInt(id)-1 ;

        stu_answers[convert_id] =stuAnswer;

    }

    public void verifyAnswers(String reg_no) throws Exception {

        for (int i = 0; i<10; i ++){
            if (stu_answers[i].equals(quizAnswers[i])){
                result[i] = "Correct";
                correct_answers += 1;
            }

            else{
                result[i] = "wrong";
            }

            //System.out.println("Student Answer "+stu_answers[i]);
            //System.out.println("Quiz Answer " + quizAnswers[i]);
        }

        System.out.println("Total number of correct answers : " + correct_answers);
    }
    
    public void quizRegistration(String reg_no, String stu_name){

        try{

            Connection connection = mysqlClass.getConnection();
            String sqlQuery = "INSERT INTO `all_result` (`reg_no`, `stu_name`, `marks`) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, reg_no);
            preparedStatement.setString(2, stu_name);
            preparedStatement.setString(3, String.valueOf(correct_answers));


            try{
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Your details successfully added to the system");

            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());
            }

            connection.close();

        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Oops..!!!\n Something went wrong with your submission..!!!" + exception.getMessage());
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
    private JTextField textField11;
    private JTextField textField12;
    private JLabel marks;
    private JFrame quizPageFrame = null;


    public quizPage() {

        quizPageFrame = setFrame(quizPagePanel, quizPageFrame);

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

                String q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;
                JFrame msgFrame = new JFrame();

                q1 = textField1.getText();
                q2 = textField2.getText();
                q3 = textField3.getText();
                q4 = textField4.getText();
                q5 = textField5.getText();
                q6 = textField6.getText();
                q7 = textField7.getText();
                q8 = textField8.getText();
                q9 = textField9.getText();
                q10 = textField10.getText();

                String[] data = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};

                int arrayIndex = 0;
                int questionNo = 1;
                 
                getAnswers();

                reg_no = textField11.getText();
                String name = textField12.getText();

                while(arrayIndex < 10)

                    try{
                        checkAnswer(String.valueOf(questionNo), data[arrayIndex]);
                        arrayIndex += 1;
                        questionNo += 1;

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                try {
                    verifyAnswers(reg_no);
                    quizRegistration(reg_no, name);

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
                textField8.setText("");
                textField9.setText("");
                textField10.setText("");

                marks.setText(String.valueOf(correct_answers));

            }
        });
    }
}
