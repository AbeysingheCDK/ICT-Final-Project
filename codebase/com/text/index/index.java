package com.text.index;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class index extends myFrameset{
    private JButton EXITButton;
    private JButton ADMINButton;
    private JButton STUDENTButton;
    private JPanel indexPanel;
    private JFrame indexFrame = null;


    public index() {
        indexFrame = setFrame(indexPanel, indexFrame);


        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             int a = JOptionPane.showConfirmDialog(null, "Do you really want to exit in this application", "Select", JOptionPane.YES_NO_OPTION);
             if (a == 0)
             {
                System.exit(0);
             }
            }
        });
        ADMINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexFrame.dispose();
                new loginAdmin();


            }
        });
        STUDENTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        STUDENTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexFrame.dispose();
                new studentHome();

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
