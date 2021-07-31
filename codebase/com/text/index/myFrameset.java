package com.text.index;
import javax.swing.*;
import java.awt.*;

public class myFrameset {
    public JFrame frame;

    public JFrame setFrame(JPanel panel, JFrame fra){

        frame = fra;

        frame = new JFrame("Quiz Exam Management System");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1500, 1000));
        frame.setResizable(true);

        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return frame;
    }
}
