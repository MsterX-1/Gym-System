package backend;
import frontend.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class FileManagement {
    private String filename;
    private ArrayList<Information> records = new ArrayList<>();

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ArrayList<Trainer> getTrainerRecords() {
        ArrayList<Trainer> trainerRecords = new ArrayList<>();
        for (Information record : records) {
            trainerRecords.add((Trainer) record);
        }
        return trainerRecords;
    }
    public ArrayList<Member> getMemberRecords() {
        ArrayList<Member> memberRecords = new ArrayList<>();
        for (Information record : records) {
            memberRecords.add((Member) record);
        }
        return memberRecords;
    }

    public ArrayList<Class> getClassRecords() {
        ArrayList<Class> memberRecords = new ArrayList<>();
        for (Information record : records) {
            memberRecords.add((Class) record);
        }
        return memberRecords;
    }
    public ArrayList<MemberClassRegistration> getRegistrationRecords() {
        ArrayList<MemberClassRegistration> registrationRecords = new ArrayList<>();
        for (Information record : records) {
            registrationRecords.add((MemberClassRegistration) record);
        }
        return registrationRecords;
    }
    public void readFromFile() {
        try {
            Scanner scan = new Scanner(new File(filename));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                records.add(createRecordFrom(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found. Creating a new one.");
        }
    }

    public abstract Information createRecordFrom(String line);

    public boolean contains(String key) {
        for (Information record : records) {
            if (key.equals(record.getSearchKey()))
                return true;
        }
        return false;
    }

    public abstract Information getRecord(String key) ;

    public void insertRecord(Information record) {
        if (!contains(record.getSearchKey())) {
            records.add(record);
           // saveToFile();//update
        } else
            System.out.println("Duplicate record found");
    }

    public void deleteRecord(String key) {
        if (contains(key)) {
            records.remove(getRecord(key));
            JOptionPane.showMessageDialog(null, "The Trainer with Id = " + key + " has been deleted.");
        }
        else {
            JOptionPane.showMessageDialog(null, "The Trainer with Id = " + key + " does not exist.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Information record : records) {
                writer.println(record.lineRepresentation());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error in saveToFile");
        }
    }


}
