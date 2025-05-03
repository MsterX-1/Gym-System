package frontend;
import backend.*;
import backend.Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class ViewClassWindow extends JFrame {
    private JTable ClassTable;
    private JPanel ViewClassWindowContainer;
    private JButton backButton;
    public ViewClassWindow(TrainerRoleWindow trainerRoleWindow, TrainerRole trainerRole) {
        ViewClassWindowContainer = new JPanel();
        ViewClassWindowContainer.setLayout(new BorderLayout());
        setContentPane(ViewClassWindowContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("View Classes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Class> Class = trainerRole.getListOfClasses();

        String[] columnNames = {"Class Id", "Class Name", "Trainer Id", "Duration", "Max Participants"};

        Object[][] data = new Object[Class.size()][5];
        for (int i = 0; i < Class.size(); i++) {
            String[] classData = Class.get(i).lineRepresentation().split(",");
            data[i][0] = classData[0]; // class Id
            data[i][1] = classData[1]; // class Name
            data[i][2] = classData[2]; // trainer id
            data[i][3] = classData[3]; // duration
            data[i][4] = classData[4]; // max participants
        }

        ClassTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(ClassTable);
        ViewClassWindowContainer.add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back");
        ViewClassWindowContainer.add(backButton, BorderLayout.SOUTH);

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
