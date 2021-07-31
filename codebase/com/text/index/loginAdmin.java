package com.text.index;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginAdmin extends myFrameset {
    private JTextField qemsTextField;
    private JPasswordField adminPasswordField;
    private JButton LOGINButton;
    private JButton BACKButton;
    private JPanel adminPanel;
    private JFrame adminFrame = null;


    public loginAdmin() {
        adminFrame = setFrame(adminPanel, adminFrame);
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