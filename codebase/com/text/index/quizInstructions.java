package com.text.index;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quizInstructions extends myFrameset {
    private JButton EXITButton;
    private JPanel quizInstructionPanel;
    private JFrame quizInstructionFrame = null;

    public quizInstructions() {
        quizInstructionFrame = setFrame(quizInstructionPanel, quizInstructionFrame);

        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Exit in this application", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0)
                {
                    quizInstructionFrame.dispose();
                    new studentHome();
                }

            }
        });
    }
}
