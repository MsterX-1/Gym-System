package frontend;

import backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewMemberWindow extends JFrame {
    private JTable memberTable;
    private JPanel ViewMemberWindowContainer;
    private JButton backButton;

    public ViewMemberWindow(TrainerRoleWindow trainerRoleWindow, TrainerRole trainerRole) {
        ViewMemberWindowContainer = new JPanel();
        ViewMemberWindowContainer.setLayout(new BorderLayout());
        setContentPane(ViewMemberWindowContainer);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("View Members");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Member> members = trainerRole.getListOfMembers();

        String[] columnNames = {"Id", "Name", "Email", "Membership Type", "Phone Number", "Status"};

        Object[][] data = new Object[members.size()][6];
        for (int i = 0; i < members.size(); i++) {
            String[] memberData = members.get(i).lineRepresentation().split(",");
            data[i][0] = memberData[0]; // Id
            data[i][1] = memberData[1]; // Name
            data[i][2] = memberData[2]; // Email
            data[i][3] = memberData[3]; // Membership Type
            data[i][4] = memberData[4]; // Phone Number
            data[i][5] = memberData[5]; // Status
        }

        memberTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(memberTable);
        ViewMemberWindowContainer.add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back");
        ViewMemberWindowContainer.add(backButton, BorderLayout.SOUTH);

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
