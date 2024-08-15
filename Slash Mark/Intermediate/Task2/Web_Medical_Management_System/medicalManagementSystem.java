package Intermediate.Task2.Web_Medical_Management_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class to represent a Patient
class Patient {
    private int id;
    private String name;
    private String disease;

    //

    public Patient(int id, String name, String disease) {
        this.id = id;
        this.name = name;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAilment() {
        return disease;
    }
    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + name + ", Ailment=" + disease + "]";
    }
}

// Class to represent a Doctor
class Doctor {
    private int id;
    private String name;
    private String specialization;
    private List<Patient> patientList;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.patientList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
        System.out.println("Patient " + patient.getName() + " added to Dr. " + name);
    }

    public void viewPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients assigned to Dr. " + name);
        } else {
            System.out.println("Patients under Dr. " + name + ":");
            for (Patient p : patientList) {
                System.out.println(p);
            }
        }
    }
}

// Class to represent the Admin
class Admin {
    private List<Doctor> doctors;

    public Admin() {
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor " + doctor.getName() + " added successfully.");
    }

    public void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            System.out.println("List of Doctors:");
            for (Doctor doc : doctors) {
                System.out.println("Doctor [ID=" + doc.getId() + ", Name=" + doc.getName() + ", Specialization=" + doc.getSpecialization() + "]");
            }
        }
    }

    public Doctor findDoctorById(int id) {
        for (Doctor doc : doctors) {
            if (doc.getId() == id) {
                return doc;
            }
        }
        System.out.println("Doctor not found.");
        return null;
    }
}

// Main class to manage the Virtual Medicine Home
public class medicalManagementSystem {
    private static Admin admin = new Admin();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n***********************************");
            System.out.println("::: Medical Management System :::");
            System.out.println("***********************************");
            System.out.println("1. Admin Login");
            System.out.println("2. Doctor Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    doctorMenu();
                    break;
                case 3:
                    System.out.println("Thank you sir/ma'am for your valuable time..:)\nVisit again...!!\n");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminMenu() {
        System.out.println("\nAdmin Menu");
        System.out.println("1. Add Doctor");
        System.out.println("2. View Doctors");
        System.out.println("3. Go Back");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Doctor ID: ");
                int id = sc.nextInt();
                sc.nextLine();  // Consume newline

                System.out.print("Enter Doctor Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Specialization: ");
                String specialization = sc.nextLine();

                Doctor doctor = new Doctor(id, name, specialization);
                admin.addDoctor(doctor);
                break;

            case 2:
                admin.viewDoctors();
                break;

            case 3:
                return;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void doctorMenu() {
        System.out.print("\nEnter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();  // Consume newline

        Doctor doctor = admin.findDoctorById(doctorId);

        if (doctor == null) {
            return;
        }

        System.out.println("\nDoctor Menu - Dr. " + doctor.getName());
        System.out.println("1. Add Patient");
        System.out.println("2. View Patients");
        System.out.println("3. Go Back");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Patient ID: ");
                int patientId = sc.nextInt();

                System.out.print("Enter Patient Name: ");
                String patientName = sc.nextLine();

                System.out.print("Enter patient's disease: ");
                String disease = sc.nextLine();

                Patient patient = new Patient(patientId, patientName, disease);
                doctor.addPatient(patient);
                break;

            case 2:
                doctor.viewPatients();
                break;

            case 3:
                return;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
