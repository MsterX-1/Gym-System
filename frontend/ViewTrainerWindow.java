package frontend;

import backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTrainerWindow extends JFrame {
    private JTable trainerTable;
    private JPanel ViewTrainerWindowContainer;
    private JButton backButton;

    public ViewTrainerWindow(AdminRoleWindow adminRoleWindow, AdminRole adminRole) {
        ViewTrainerWindowContainer = new JPanel();
        ViewTrainerWindowContainer.setLayout(new BorderLayout());
        setContentPane(ViewTrainerWindowContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("View Trainers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Trainer[] trainers = adminRole.getListOfTrainers();

        String[] columnNames = {"Id", "Name", "Email", "Speciality", "Phone Number"};

        Object[][] data = new Object[trainers.length][5];
        for (int i = 0; i < trainers.length; i++) {
            String[] trainerData = trainers[i].lineRepresentation().split(",");

                data[i][0] = trainerData[0]; // Id
                data[i][2] = trainerData[1]; // Name
                data[i][1] = trainerData[2]; // Email
                data[i][3] = trainerData[3]; // Speciality
                data[i][4] = trainerData[4]; // Phone Number

        }

        trainerTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(trainerTable);
        ViewTrainerWindowContainer.add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back");
        ViewTrainerWindowContainer.add(backButton, BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminRoleWindow.setVisible(true);
                dispose();
            }
        });

    }
}
