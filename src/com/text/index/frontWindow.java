package com.text.index;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frontWindow extends myFrameset{
    private JButton letSGoButton;
    private JPanel frontWindowPanel;
    private JFrame frontWindowFrame = null;


    public frontWindow() {
        frontWindowFrame = setFrame(frontWindowPanel, frontWindowFrame);

        letSGoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frontWindowFrame.dispose();
                new index();


            }
        });
    }
}
