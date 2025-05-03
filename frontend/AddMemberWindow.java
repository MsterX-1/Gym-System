package frontend;
import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMemberWindow extends JFrame {
    private JTextField Id_Field;
    private JTextField Name_Field;
    private JTextField Email_Field;
    private JTextField Membership_Field;
    private JTextField PhoneNum_Field;
    private JTextField Status_Field;
    private JButton addButton;
    private JPanel AddMemberContainer;

    public AddMemberWindow(TrainerRoleWindow trainerRoleWindow, TrainerRole trainerRole) {
        setVisible(true);
        setContentPane(AddMemberContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Add Member");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = Id_Field.getText().trim();
                String name = Name_Field.getText();
                String email = Email_Field.getText().trim();
                String membership = Membership_Field.getText();
                String phoneNum = PhoneNum_Field.getText();
                String status = Status_Field.getText();
                if (id.isEmpty() || name.isEmpty() || email.isEmpty() || phoneNum.isEmpty() || status.isEmpty()) {
                    JOptionPane.showMessageDialog(AddMemberContainer, "Some fields are Empty!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    trainerRole.addMember(id, name, email, membership, phoneNum, status);
                    dispose();
                    trainerRoleWindow.setVisible(true);
                }
            }
        });
    }
}
