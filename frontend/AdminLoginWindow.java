package frontend;
import constants.LoginCredentials;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginWindow extends JFrame implements LoginCredentials {
    private JPanel AdminLoginContainer;
    private JButton loginButton;
    private JTextField UserNameScreen;
    private JPasswordField PasswordScreen;

    public AdminLoginWindow(MainWindow mainWindow) {
        setVisible(true);
        setContentPane(AdminLoginContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Admin Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = UserNameScreen.getText().trim();
                String password = new String(PasswordScreen.getPassword()).trim();
                if(username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                    JOptionPane.showMessageDialog(AdminLoginContainer, "Login Successful");
                    new AdminRoleWindow(mainWindow);
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(AdminLoginContainer, "Wrong username or password!","Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

}

