
#Flowchart for the Web Medical Management System

    #1. Start

    #2. Main Menu
            - Admin Login
            - Doctor Login
            - Exit

    #3. Admin Menu
            #3.1 Add Doctor
                - Input Doctor ID, Name, and - Specialization.
                - Add Doctor to Admin’s list
            #3.2 View Doctors
                - Display list of all doctors
            #3.3 Go Back to Main Menu

    #4. Doctor Menu
            #4.1 Add Patient
                - Input Patient ID, Name, and Disease
                - Add Patient to Doctor’s list
            #4.2 View Patients
                - Display list of all patients assigned to the doctor
            #4.3 Go Back to Main Menu
    #5 Exit Program

#Algorithm :-

    #1. Main Function:
        - Initialize Admin object
        - Display Main Menu
        - Take user input for selection
        - Based on selection, navigate to Admin Menu, Doctor Menu, or Exit.

    #2. Admin Menu:
        #2.1 If option 1 selected:
            - Prompt user for Doctor ID, Name, and Specialization
            - Create a new Doctor object
            - Add the Doctor object to Admin's list
        #2.2 If option 2 selected:
            - Display all doctors in Admin’s list
        #2.3 If option 3 selected:
            - Go back to the Main Menu

    #3. Doctor Menu:
        #3.1 If option 1 selected:
                - Prompt user for Patient ID, Name, and Disease
                - Create a new Patient object
                - Add the Patient object to the Doctor’s list
        #3.2 If option 2 selected:
                - Display all patients assigned to the doctor
        #3.3 If option 3 selected:
                - Go back to the Main Menu

    #4. Exit Program:
            - End the program and close any open resources.


#Structure_of_the_program : -

Intermediate.Task2.Web_Medical_Management_System
│
├── Patient Class
│   ├── Attributes: id, name, disease
│   ├── Constructor: Patient(int id, String name, String disease)
│   ├── Methods: getId(), getName(), getAilment(), toString()
│
├── Doctor Class
│   ├── Attributes: id, name, specialization, List<Patient> patientList
│   ├── Constructor: Doctor(int id, String name, String specialization)
│   ├── Methods: getId(), getName(), getSpecialization(), addPatient(Patient), viewPatients()
│
├── Admin Class
│   ├── Attributes: List<Doctor> doctors
│   ├── Constructor: Admin()
│   ├── Methods: addDoctor(Doctor), viewDoctors(), findDoctorById(int id)
│
└── medicalManagementSystem Class
    ├── Attributes: Admin admin, Scanner sc
    ├── Methods: main(String[] args), adminMenu(), doctorMenu()
