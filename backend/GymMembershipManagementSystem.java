package backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GymMembershipManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminRole adminRole = new AdminRole();
        TrainerRole trainerRole = new TrainerRole();
        boolean exit = false;

        while (!exit) {
            System.out.println("Select Role:");
            System.out.println("1. Admin");
            System.out.println("2. Trainer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleAdmin(scanner, adminRole);
                    break;
                case 2:
                    handleTrainer(scanner, trainerRole);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Exiting the application.");
    }

    private static void handleAdmin(Scanner scanner, AdminRole adminRole) {
        boolean exitAdmin = false;

        while (!exitAdmin) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Trainer");
            System.out.println("2. List Trainers");
            System.out.println("3. Remove Trainer");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Trainer ID: ");
                    String trainerId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Speciality: ");
                    String speciality = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    adminRole.addTrainer(trainerId, name, email, speciality, phoneNumber);
                    break;
                case 2:
                    Trainer[] trainers = adminRole.getListOfTrainers();
                    System.out.println("List of Trainers:");
                    for (Trainer trainer : trainers) {
                        System.out.println(trainer.lineRepresentation());
                    }
                    break;
                case 3:
                    System.out.print("Enter Trainer ID to remove: ");
                    String key = scanner.nextLine();
                    adminRole.removeTrainer(key);
                    break;
                case 4:
                    adminRole.logout();
                    exitAdmin = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleTrainer(Scanner scanner, TrainerRole trainerRole) {
        boolean exitTrainer = false;

        while (!exitTrainer) {
            System.out.println("Trainer Menu:");
            System.out.println("1. Add Member");
            System.out.println("2. List Members");
            System.out.println("3. Add Class");
            System.out.println("4. List Classes");
            System.out.println("5. Register Member for Class");
            System.out.println("6. Cancel Registration");
            System.out.println("7. List Registrations");
            System.out.println("8. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Enter Membership Type: ");
                    String membershipType = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String memberEmail = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String memberPhoneNumber = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String status = scanner.nextLine();
                    trainerRole.addMember(memberId, memberName, membershipType, memberEmail, memberPhoneNumber, status);
                    break;
                case 2:
                    ArrayList<Member> members = trainerRole.getListOfMembers();
                    System.out.println("List of Members:");
                    for (Member member : members) {
                        System.out.println(member.lineRepresentation());
                    }
                    break;
                case 3:
                    System.out.print("Enter Class ID: ");
                    String classId = scanner.nextLine();
                    System.out.print("Enter Class Name: ");
                    String className = scanner.nextLine();
                    System.out.print("Enter Trainer ID: ");
                    String trainerId = scanner.nextLine();
                    System.out.print("Enter Duration: ");
                    int duration = scanner.nextInt();
                    System.out.print("Enter Max Participants: ");
                    int maxParticipants = scanner.nextInt();
                    trainerRole.addClass(classId, className, trainerId, duration, maxParticipants);
                    break;
                case 4:
                    ArrayList<Class> classes = trainerRole.getListOfClasses();
                    System.out.println("List of Classes:");
                    for (Class c : classes) {
                        System.out.println(c.lineRepresentation());
                    }
                    break;
                case 5:
                    System.out.print("Enter Member ID to register: ");
                    String regMemberId = scanner.nextLine();
                    System.out.print("Enter Class ID to register: ");
                    String regClassId = scanner.nextLine();
                    LocalDate registrationDate = LocalDate.now();
                    boolean registered = trainerRole.registerMemberForClass(regMemberId, regClassId, registrationDate);
                    if (registered) {
                        System.out.println("Registration successful.");
                    } else {
                        System.out.println("Registration failed. Check class availability.");
                    }
                    break;
                case 6:
                    System.out.print("Enter Member ID to cancel registration: ");
                    String cancelMemberId = scanner.nextLine();
                    System.out.print("Enter Class ID to cancel: ");
                    String cancelClassId = scanner.nextLine();
                    boolean cancelled = trainerRole.cancelRegistration(cancelMemberId, cancelClassId);
                    if (cancelled) {
                        System.out.println("Registration cancelled successfully.");
                    } else {
                        System.out.println("Cancellation failed. Check registration date.");
                    }
                    break;
                case 7:
                    ArrayList<MemberClassRegistration> registrations = trainerRole.getListOfRegistrations();
                    System.out.println("List of Registrations:");
                    for (MemberClassRegistration registration : registrations) {
                        System.out.println(registration.lineRepresentation());
                    }
                    break;
                case 8:
                    trainerRole.logout();
                    exitTrainer = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
