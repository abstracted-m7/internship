
import csv

# In Csv store contacts
contact_file = 'ContactsInfo.csv'

# Function to load contacts from the CSV file
def load_contacts():
    contacts = []
    try:
        with open(contact_file, mode='r', newline='') as file:
            reader = csv.DictReader(file)
            for row in reader:
                contacts.append(row)

    except FileNotFoundError:
        print(f"The file {contact_file} does not exist.")

    return contacts

# save contact to csv file
def save_contacts(contacts):
    with open(contact_file, mode='w', newline='') as file:
        fieldnames = ['Name', 'Phone', 'Email']
        writer = csv.DictWriter(file, fieldnames=fieldnames)
        writer.writeheader()
        writer.writerows(contacts)

# Function to add a new contact
def add_contact(contacts):
    name = input("Enter contact name: ")
    phone = input("Enter contact phone number: ")
    email = input("Enter contact email address: ")
    
    contacts.append({'Name': name, 'Phone': phone, 'Email': email})
    save_contacts(contacts)
    print("Contact added successfully!")

# Function to view all contacts
def view_contacts(contacts):
    if not contacts:
        print("No contacts found.")
    else:
        print("\nContact List:")
        for idx, contact in enumerate(contacts, start=1):
            print(f"{idx}. Name: {contact['Name']}, Phone: {contact['Phone']}, Email: {contact['Email']}")
        print()

# Function to edit an existing contact
def edit_contact(contacts):
    view_contacts(contacts)
    try:
        choice = int(input("Enter the number of the contact to edit: "))
        if 1 <= choice <= len(contacts):
            contact = contacts[choice - 1]
            print(f"Editing Contact: {contact['Name']}")
            contact['Name'] = input(f"Enter new name (current: {contact['Name']}): ") or contact['Name']
            contact['Phone'] = input(f"Enter new phone number (current: {contact['Phone']}): ") or contact['Phone']
            contact['Email'] = input(f"Enter new email address (current: {contact['Email']}): ") or contact['Email']
            save_contacts(contacts)
            print("Contact updated successfully!")
        else:
            print("Invalid contact number.")
    except ValueError:
        print("Invalid input. Please enter a number.")

# Function to delete a contact
def delete_contact(contacts):
    view_contacts(contacts)
    try:
        choice = int(input("Enter the number of the contact to delete: "))
        if 1 <= choice <= len(contacts):
            contacts.pop(choice - 1)
            save_contacts(contacts)
            print("Contact deleted successfully!")
        else:
            print("Invalid contact number.")
    except ValueError:
        print("Invalid input. Please enter a number.")

# Main function to run the contact management program
def main():
    contacts = load_contacts()
    user = input("Enter your name : ")
    while True:
    
        print("\nContact Management System")
        print("1. Add New Contact")
        print("2. View Contacts")
        print("3. Edit Contact")
        print("4. Delete Contact")
        print("5. Exit")
        
        choice = input("Enter your choice: ")
        
        if choice == '1':
            add_contact(contacts)
        elif choice == '2':
            view_contacts(contacts)
        elif choice == '3':
            edit_contact(contacts)
        elif choice == '4':
            delete_contact(contacts)
        elif choice == '5':
            print(f"\n\nProgram ended..!!\nThank you Visit again {user} :) ")
            break
        else:
            print("Invalid choice. Please enter a number between 1 and 5.")

if __name__ == "__main__":
    main()
