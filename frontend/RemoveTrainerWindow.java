package frontend;
import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveTrainerWindow extends JFrame {
    private JButton removeButton;
    private JTextField TrainerIdField;
    private JPanel RemoveTrainerContainer;

    public RemoveTrainerWindow(AdminRoleWindow adminRoleWindow,AdminRole adminRole) {
        setVisible(true);
        setContentPane(RemoveTrainerContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Remove Trainer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String TrainerId=TrainerIdField.getText().trim();
               if (TrainerId.isEmpty()) {
                   JOptionPane.showMessageDialog(RemoveTrainerContainer, "Please enter Trainer ID");
               }
               else {
                   adminRole.removeTrainer(TrainerId);
                   dispose();
                   adminRoleWindow.setVisible(true);
               }

            }
        });
    }
}
