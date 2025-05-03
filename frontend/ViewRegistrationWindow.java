package frontend;
import backend.*;
import backend.Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class ViewRegistrationWindow extends JFrame {
    private JPanel ViewRegistraionWindowContainer;
    private JTable RegistrationTable;
    private JButton backButton;
    public ViewRegistrationWindow(TrainerRoleWindow trainerRoleWindow, TrainerRole trainerRole) {
        ViewRegistraionWindowContainer = new JPanel();
        ViewRegistraionWindowContainer.setLayout(new BorderLayout());
        setContentPane(ViewRegistraionWindowContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("View Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<MemberClassRegistration> Registration = trainerRole.getListOfRegistrations();

        String[] columnNames = {"Member Id", "Class Id", "Registration Date","Status"};

        Object[][] data = new Object[Registration.size()][4];
        for (int i = 0; i < Registration.size(); i++) {
            String[] RegistrationData = Registration.get(i).lineRepresentation().split(",");
            data[i][0] = RegistrationData[0]; // member Id
            data[i][1] = RegistrationData[1]; // class id
            data[i][2] = RegistrationData[2]; // registration date
            data[i][3] = RegistrationData[3]; // status
        }

        RegistrationTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(RegistrationTable);
        ViewRegistraionWindowContainer.add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back");
        ViewRegistraionWindowContainer.add(backButton, BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainerRoleWindow.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}
