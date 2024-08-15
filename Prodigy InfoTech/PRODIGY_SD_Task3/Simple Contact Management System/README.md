Working Procedure:

    Contact Storage:
        Contacts are stored in a CSV file (contacts.csv). Each contact includes a name, phone number, and email address.

    Load Contacts:
        The load_contacts function reads contacts from the CSV file and loads them into memory as a list of dictionaries.

    Save Contacts:
        The save_contacts function writes the contacts from memory back to the CSV file.

    Add a New Contact:
        The add_contact function prompts the user to enter a name, phone number, and email address, then adds this information to the contacts list and saves it to the file.

    View Contacts:
        The view_contacts function displays the list of contacts, with each contact's name, phone number, and email address.

    Edit an Existing Contact:
        The edit_contact function allows the user to select a contact to edit. The user can update the name, phone number, or email address of the selected contact. The updated contact is then saved back to the file.

    Delete a Contact:
        The delete_contact function allows the user to select and delete a contact from the list. The updated list is then saved back to the file.

    Main Program Loop:
        The main function runs a loop that displays the menu, handles user input, and calls the appropriate functions based on the user's choice.

How to Run the Program:

    Save the code in a file, e.g., contact_manager.py.
    Run the program in a Python environment.
    The program will display a menu for managing contacts and allow users to add, view, edit, and delete contacts.

ChatGPT ca