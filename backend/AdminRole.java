package backend;

import javax.swing.*;

public class AdminRole implements Role {
   private TrainerDatabase database;

    public AdminRole() {
        database = new TrainerDatabase("Trainers.txt");
    }
    public void addTrainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        if(!database.contains(trainerId)) {
            database.insertRecord(new Trainer(trainerId, name, email, speciality, phoneNumber) );
            //GUI line
            JOptionPane.showMessageDialog(null, "The Trainer with Id = " + trainerId + " has successfully added");

        }
        else
           // System.out.println("Trainer already exists");
        //GUI line
            JOptionPane.showMessageDialog(null, "Trainer with Id = "+trainerId+" already exists!","Error",JOptionPane.ERROR_MESSAGE);
    }

    public Trainer[] getListOfTrainers() {
        return database.returnAllRecords().toArray(new Trainer[0]);
    }

    public void removeTrainer(String key) {
        database.deleteRecord(key);
    }
    @Override
    public void logout() {
        database.saveToFile();
    }
}
