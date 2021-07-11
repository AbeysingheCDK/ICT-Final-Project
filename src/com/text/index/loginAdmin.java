package com.text.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginAdmin {
    private JTextField qemsTextField;
    private JPasswordField adminPasswordField;
    private JCheckBox showPasswordCheckBox;
    private JButton LOGINButton;
    private JButton BACKButton;
    private JPanel adminPanel;
    private JFrame adminFrame;


    public loginAdmin() {
        adminFrame = new JFrame("Quiz Exam Management System");
        adminFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        adminFrame.setPreferredSize(new Dimension(600, 500));
        adminFrame.setResizable(true);

        adminFrame.add(adminPanel);

        adminFrame.pack();
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setVisible(true);

        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.dispose();
                new index();


            }
        });
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.dispose();
                new adminHome();


            }
        });


    }

}