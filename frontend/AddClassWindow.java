package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClassWindow extends JFrame {
    private JTextField ClassId_Field;
    private JTextField ClassName_Field;
    private JTextField TrainerId_Field;
    private JTextField Duration_Field;
    private JTextField MaxParticipants_Field;
    private JButton addButton;
    private JPanel AddClassContainer;

    public AddClassWindow(TrainerRoleWindow trainerRoleWindow, TrainerRole trainerRole) {
        setVisible(true);
        setContentPane(AddClassContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("Add Class");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String classId = ClassId_Field.getText();
                String className = ClassName_Field.getText();
                String trainerId = TrainerId_Field.getText();
                int duration = Integer.parseInt(Duration_Field.getText());
                int maxParticipants = Integer.parseInt(MaxParticipants_Field.getText());
                if(classId.isEmpty() || className.isEmpty() || trainerId.isEmpty() || duration <= 0 || maxParticipants <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    trainerRole.addClass(classId, className, trainerId, duration, maxParticipants);
                    dispose();
                    trainerRoleWindow.setVisible(true);
                }



            }
        });
    }
}
