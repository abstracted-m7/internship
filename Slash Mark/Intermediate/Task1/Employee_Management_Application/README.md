
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

#Structure_of_the_programm :- 

Intermediate.Task1.Employee_Management_Application
│
├── Employee Class
│   ├── Attributes: id, name, department, salary
│   ├── Constructor: Employee(int id, String name, String department, double salary)
│   ├── Methods: getId(), setId(int id), getName(), setName(String name), getDepartment(), setDepartment(String department), getSalary(), setSalary(double salary), toString()
│
└── EmployeeManagementSystem Class
    ├── Attributes: ArrayList<Employee> employeeList
    ├── Constructor: EmployeeManagementSystem()
    ├── Methods: addEmployee(), viewEmployees(), updateEmployee(), deleteEmployee()
    └── Main Method: main(String[] args)
