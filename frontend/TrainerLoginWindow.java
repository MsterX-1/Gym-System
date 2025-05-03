package frontend;
import constants.LoginCredentials;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainerLoginWindow extends JFrame implements LoginCredentials {
    private JPanel TrainerLoginContainer;
    private JButton loginButton;
    private JTextField UserNameScreen;
    private JPasswordField PasswordScreen;

    public TrainerLoginWindow(MainWindow mainWindow) {
        setVisible(true);
        setContentPane(TrainerLoginContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Trainer Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = UserNameScreen.getText().trim();
                String password = new String(PasswordScreen.getPassword()).trim();
                if (username.equals(TRAINER_USERNAME) && password.equals(TRAINER_PASSWORD)) {
                    JOptionPane.showMessageDialog(TrainerLoginContainer, "Login Successful");
                    new TrainerRoleWindow(mainWindow);
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(TrainerLoginContainer, "Wrong Username or Password","Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
