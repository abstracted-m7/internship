
#Flowchart for the Employee Management System

    #1. Start
    #2. Main Menu
            - Add Employee
            - View Employees
            - Update Employee
            - Delete Employee
            - Exit
    #3. Add Employee
            - Input Employee ID, Name, Department, Salary
            - Add Employee to the employee list
    #4. View Employees
            - Display all employees in the employee list
    #5. Update Employee
            - Input Employee ID
            - If Employee ID exists, input new details and update the employee
    #6. Delete Employee
            - Input Employee ID
            - If Employee ID exists, delete the employee from the list
    #7. Exit Program

#Algorithm :- 

    #1. Main Function:
            - Initialize EmployeeManagementSystem object
            - Display Main Menu with options
            - Take user input for selection
            - Based on selection, call methods to add, view, update, delete employees, or exit.

    #2. Add Employee:
            - Prompt for Employee ID, Name, Department, and Salary
            - Create a new Employee object
            - Add the Employee object to employeeList

    #3. View Employees:
            - Check if employeeList is empty
            - If not, display all employees

    #4. Update Employee:
            - Prompt for Employee ID
            - If Employee ID exists, prompt for new Name, Department, and Salary
            - Update the corresponding Employee object

    #5. Delete Employee:
            - Prompt for Employee ID
            - If Employee ID exists, remove the Employee object from employeeList

    #6. Exit Program:
            - End the program and close any open resources

#Project_Overview:-
#Name : Employee Management System

The Employee Management System is a Java-based application designed to streamline and simplify the management of employee information within an organization. This system allows administrators to efficiently add, view, update, and delete employee records, making it an essential tool for Human Resources (HR) departments.
Key Features

    - Add Employee: Easily add new employees to the system by providing details such as ID, name, department, and salary.
    - View Employees: Display a list of all employees, including their key details.
    - Update Employee: Modify existing employee records, including their name, department, and salary information.
    - Delete Employee: Remove employee records from the system when they are no longer needed.
    - User-Friendly Interface: The system features a text-based menu interface, making it easy to navigate through various options.

Purpose

The primary objective of this project is to provide a simple yet effective solution for managing employee records. This system is particularly useful for small to medium-sized organizations where maintaining a database of employee information is crucial. By automating these tasks, the system reduces the likelihood of errors and ensures that all employee data is up-to-date.
Technology Stack

    - Language: Java
    - Libraries: Standard Java Libraries (e.g., java.util, java.io)
    - Tools: Java Development Kit (JDK), Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse

Future Enhancements

    - Database Integration: Moving from in-memory storage to a persistent database to handle larger datasets.
    - Role-Based Access: Implementing user roles (e.g., Admin, HR, Manager) with different levels of access and control.
    - Graphical User Interface (GUI): Enhancing the user experience by adding a GUI, possibly using JavaFX or Swing.
