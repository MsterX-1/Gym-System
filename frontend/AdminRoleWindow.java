package frontend;
import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRoleWindow extends JFrame {
    private JButton logoutButton;
    private JButton viewTrainersButton;
    private JButton removeTrainerButton;
    private JButton addTrainerButton;
    private JPanel AdminRoleContainer;


    public AdminRoleWindow(MainWindow mainWindow) {
        AdminRole adminRole = new AdminRole();
        AdminRoleWindow adminRoleWindow = this;
        setVisible(true);
        setContentPane(AdminRoleContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Admin Role");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTrainerWindow(adminRoleWindow,adminRole);
                setVisible(false);
            }
        });
        removeTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveTrainerWindow(adminRoleWindow,adminRole);
                setVisible(false);

            }
        });
        viewTrainersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewTrainerWindow(adminRoleWindow,adminRole);
                setVisible(false);

            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminRole.logout();
                dispose();
                mainWindow.setVisible(true);
            }
        });
    }
}
