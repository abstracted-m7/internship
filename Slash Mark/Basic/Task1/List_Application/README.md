
### Explanation:

### Overview:
The program is a simple task manager that lets users add, remove, and view tasks using a text-based interface. The tasks are stored in an `ArrayList<String>`. The program runs in a loop, continuously displaying a menu until the user decides to exit.

### Key-Components:

1. **Task Storage**:
   - An `ArrayList<String>` named `tasks` is used to store the list of tasks. Each task is a string, and tasks are added, removed, or listed from this collection.

2. **User Input**:
   - A `Scanner` object named `scanner` is used to read user input from the console. The input is taken as strings and parsed into integers where necessary.

3. **Main Loop**:
   - The `main` method contains a `while(true)` loop that keeps the program running until the user chooses to exit.
   - Inside the loop, the `printMenu()` method displays the menu options: Add Task, Remove Task, List Tasks, and Exit.
   - The user's choice is read and processed using the `getUserChoice()` method, which ensures the input is a valid number.

4. **Adding Tasks**:
   - The `addTask()` method prompts the user to enter a new task, which is then added to the `tasks` list.
   - After adding, a confirmation message is displayed.

5. **Removing Tasks**:
   - The `removeTask()` method first checks if there are any tasks to remove.
   - It lists all the tasks with their corresponding numbers, then prompts the user to enter the number of the task to remove.
   - The task is removed from the list, and a confirmation message is shown.

6. **Listing Tasks**:
   - The `listTasks()` method displays all the current tasks with their numbers.
   - If there are no tasks, a message indicating this is shown.

7. **Exiting the Program**:
   - If the user selects the exit option (choice 4), the loop breaks, and the program ends with a goodbye message.

### Error Handling:
- The program includes basic error handling:
  - If a user enters something other than a number when choosing an option, the program catches the exception and prompts the user to enter a valid number.
  - When removing a task, if the user enters a number outside the valid range, the program informs them of the invalid input.
