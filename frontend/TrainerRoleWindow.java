package frontend;
import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainerRoleWindow extends JFrame {
    private JButton addMemberButton;
    private JButton viewMemberButton;
    private JButton cancelRegistrationButton;
    private JButton viewRegistrationsButton;
    private JButton logoutButton;
    private JButton registerMemberForClassButton;
    private JButton viewClassesButton;
    private JButton addClassButton;
    private JPanel TrainerRoleWindowContainer;

    public TrainerRoleWindow(MainWindow mainWindow) {
        TrainerRole trainerRole = new TrainerRole();
        TrainerRoleWindow trainerRoleWindow = this;
        setVisible(true);
        setContentPane(TrainerRoleWindowContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Trainer Role");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMemberWindow(trainerRoleWindow,trainerRole);
                setVisible(false);
            }
        });
        viewMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewMemberWindow(trainerRoleWindow,trainerRole);
                setVisible(false);
            }
        });
        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddClassWindow(trainerRoleWindow,trainerRole);
                setVisible(false);
            }
        });
        viewClassesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewClassWindow(trainerRoleWindow,trainerRole);
                setVisible(false);
            }
        });
        registerMemberForClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterMemberWindow(trainerRoleWindow,trainerRole);
                setVisible(false);
            }
        });
        cancelRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CancelRegistrationWindow(trainerRoleWindow,trainerRole);
                setVisible(false);
            }
        });
        viewRegistrationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewRegistrationWindow(trainerRoleWindow,trainerRole);
                setVisible(false);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainerRole.logout();
                dispose();
                mainWindow.setVisible(true);
            }
        });
    }
}
