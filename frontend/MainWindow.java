package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow  extends JFrame {
    private JButton adminRoleButton;
    private JButton trainerRoleButton;
    private JPanel MainWindowContainer;

    public MainWindow() {
        setVisible(true);
        setContentPane(MainWindowContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Gym System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow MainWindow =this;

        adminRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminLoginWindow(MainWindow);
                setVisible(false);
            }
        });
        trainerRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TrainerLoginWindow(MainWindow);
                setVisible(false);
            }
        });
    }
    public static void main(String[] args) {
        new MainWindow();
    }
}
