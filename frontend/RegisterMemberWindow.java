package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class RegisterMemberWindow extends JFrame {
    private JTextField MemberIdField;
    private JTextField ClassIdField;
    private JButton addButton;
    private JPanel RegisterMemberWindowContainer;

    public RegisterMemberWindow(TrainerRoleWindow trainerRoleWindow, TrainerRole trainerRole) {
        setVisible(true);
        setContentPane(RegisterMemberWindowContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Register Member");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = MemberIdField.getText();
                String classId = ClassIdField.getText();
                LocalDate date = LocalDate.now();
                if (memberId.isEmpty() || classId.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterMemberWindowContainer, "Please enter memberId and classId","Error",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    trainerRole.registerMemberForClass(memberId, classId, date);
                    dispose();
                    trainerRoleWindow.setVisible(true);
                }
            }
        });
    }
}
