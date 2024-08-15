package Intermediate.Task1.Employee_Management_Application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

public class EmployeeManagementSystem {

    private ArrayList<Employee> employeeList;

    public EmployeeManagementSystem() {
        employeeList = new ArrayList<>();
    }


    // disable specific compiler warnings -> Suppresses all warnings.
    @SuppressWarnings("all")
    // Method to add an employee
    public void addEmployee() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter employee ID: ");
            int id = sc.nextInt();

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Enter department: ");
            String department = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, department, salary);
            employeeList.add(emp);
            System.out.println("Employee added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    // Method to view all employees
    public void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
        }
    }


    // disable specific compiler warnings -> Suppresses all warnings.
    @SuppressWarnings("all")

    // Method to update an employee
    public void updateEmployee() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter employee ID to update: ");
            int id = sc.nextInt();

            for (Employee emp : employeeList) {
                if (emp.getId() == id) {

                    System.out.print("Enter new name: ");
                    emp.setName(sc.nextLine());

                    System.out.print("Enter new department: ");
                    emp.setDepartment(sc.nextLine());

                    System.out.print("Enter new salary: ");
                    emp.setSalary(sc.nextDouble());

                    System.out.println("Employee updated successfully!");
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    
    // disable specific compiler warnings -> Suppresses all warnings.
    @SuppressWarnings("all")
    // Method to delete an employee
    public void deleteEmployee() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter employee ID to delete: ");
            int id = sc.nextInt();

            for (Employee emp : employeeList) {
                if (emp.getId() == id) {
                    employeeList.remove(emp);
                    System.out.println("Employee deleted successfully!");
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    // Main method
    public static void main(String[] args) {
        EmployeeManagementSystem EmployeeManagementSystem = new EmployeeManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("\n::: Employee Management System :::");
            System.out.println("\n***********************************\n");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        EmployeeManagementSystem.addEmployee();
                        break;

                    case 2:
                        EmployeeManagementSystem.viewEmployees();
                        break;

                    case 3:
                        EmployeeManagementSystem.updateEmployee();
                        break;

                    case 4:
                        EmployeeManagementSystem.deleteEmployee();
                        break;

                    case 5:
                        System.out.println("\nThank you sir/ma'am for your valuable time...:)\nVisit Again...!!\n");
                        sc.close();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
