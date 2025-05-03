package frontend;
import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTrainerWindow extends JFrame {
    private JTextField Id_Field;
    private JTextField Email_Field;
    private JTextField Name_Field;
    private JTextField Speciality_Field;
    private JTextField phoneNum_Field;
    private JButton addButton;
    private JPanel AddTrainerContainer;

    public AddTrainerWindow(AdminRoleWindow adminRoleWindow,AdminRole adminRole) {

        setVisible(true);
        setContentPane(AddTrainerContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Admin Role");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = Id_Field.getText().trim();
                String email = Email_Field.getText().trim();
                String name = Name_Field.getText();
                String speciality = Speciality_Field.getText().trim();
                String phoneNum = phoneNum_Field.getText().trim();
                if (id.isEmpty() || email.isEmpty() || name.isEmpty() || speciality.isEmpty() || phoneNum.isEmpty()) {
                    JOptionPane.showMessageDialog(AddTrainerContainer, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    adminRole.addTrainer(id, email, name, speciality, phoneNum);
                    dispose();
                    adminRoleWindow.setVisible(true);
                }


            }
        });
    }
}
