package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelRegistrationWindow extends JFrame {
    private JPanel CancelRegistrationWindowContainer;
    private JTextField MemberIdField;
    private JTextField ClassIdField;
    private JButton cancelRegistrationButton;

    public CancelRegistrationWindow(TrainerRoleWindow trainerRoleWindow, TrainerRole trainerRole) {
        setVisible(true);
        setContentPane(CancelRegistrationWindowContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Cancel Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cancelRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = MemberIdField.getText();
                String classId = ClassIdField.getText();
                if (memberId.isEmpty() && classId.isEmpty()) {
                    JOptionPane.showMessageDialog(CancelRegistrationWindowContainer.getRootPane(), "Please enter all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    trainerRole.cancelRegistration(memberId, classId);
                    dispose();
                    trainerRoleWindow.setVisible(true);
                }
            }
        });
    }
}
