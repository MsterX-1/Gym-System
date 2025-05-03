package backend;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class TrainerRole implements Role {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole() {
        memberDatabase = new MemberDatabase("Members.txt");
        classDatabase = new ClassDatabase("Class.txt");
        registrationDatabase = new MemberClassRegistrationDatabase("Registrations.txt");
    }

    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        if (!memberDatabase.contains(memberID)) {
            memberDatabase.insertRecord(new Member(memberID, name, membershipType, email, phoneNumber, status));
            JOptionPane.showMessageDialog(null, "The Member with Id = " + memberID + " has successfully added");
        }
        else {
            // System.out.println("Member already exists");
            JOptionPane.showMessageDialog(null, "Member with Id = " + memberID + " already exists!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }


    public ArrayList<Member> getListOfMembers() {
        return memberDatabase.returnAllRecords();
    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        classDatabase.insertRecord(new Class(classID, className, trainerID, "" + duration, "" + maxParticipants));
        JOptionPane.showMessageDialog(null, "The Class with Id = " + classID + " has successfully added");
    }

    public ArrayList<Class> getListOfClasses() {
        return classDatabase.returnAllRecords();
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        Class c = classDatabase.getRecord(classID);
        if (c != null && c.getAvailableSeats() > 0) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = registrationDate.format(formatter);
            registrationDatabase.insertRecord(new MemberClassRegistration(memberID, classID, date, "Active"));
            c.setAvailableSeats(c.getAvailableSeats() - 1);
            JOptionPane.showMessageDialog(null, "The Member with Id = " + memberID + " has successfully registered to class "+classID);
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "The Class has no available seats!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }
    public boolean cancelRegistration(String memberID, String classID) {
        LocalDate currentDate = LocalDate.now();
        MemberClassRegistration registration = registrationDatabase.getRecord(memberID + classID);

        if (registration != null) {
            LocalDate registrationDate = registration.getRegistrationDate();
            long daysBetween = ChronoUnit.DAYS.between(registrationDate, currentDate);

            if (daysBetween <= 3) {
                registration.setStatus("Cancelled");
                Class c = classDatabase.getRecord(classID);
                c.setAvailableSeats(c.getAvailableSeats() + 1);
                JOptionPane.showMessageDialog(null, "The Member with Id = " + memberID + " has been unregistered from class "+classID);
                return true;
            }
        }
            JOptionPane.showMessageDialog(null, "Member with Id = " + memberID + " or Class with Id = "+classID+ " does not exist!","Error",JOptionPane.ERROR_MESSAGE);
            return false;


    }

    public ArrayList<MemberClassRegistration> getListOfRegistrations() {
        return registrationDatabase.returnAllRecords();
    }

    public void logout() {
        memberDatabase.saveToFile();
        registrationDatabase.saveToFile();
        classDatabase.saveToFile();
    }
}
