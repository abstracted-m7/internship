
#Flowchart

    #1. Start
    #2. Display Rules
    #3. User Menu
        #3.1. Generate Password
                - Generate random password
                - Display password
                - Back to Menu
        #3.2. Check Password Strength
                - Input password
                - Check strength
                - Display result
                - Back to Menu
        #3.3. Encrypt Password
                - Input password
                - Generate salt
                - Hash password with salt
                - Display encrypted password
                - Back to Menu
        #3.4. Exit
                - Display Exit Message
                - End


#Algorithm ;-

    #1. Start
    #2. Display Rules: Show the user the rules for a strong password.
    #3. Loop (User Interaction):
        #3.1 Display menu options:
                - Generate Password
                - Check Password Strength
                - Encrypt Password
                - Exit
        #3.2 User Input: Prompt user to select an option.
        #3.3 Switch Case Based on User Choice:
                - Case 1: Generate Password
                    - Combine characters, numbers, and symbols.
                    - Randomly select characters to form an 8-character password.
                    - Display the generated password.
                - Case 2: Check Password Strength
                    - Prompt the user to input a password.
                    - Check if the password meets the criteria for length, lowercase, uppercase, numbers, and special characters.
                    - Display if the password is strong or weak.
                - Case 3: Encrypt Password
                    - Prompt the user to input a password.
                    - Generate a salt using SecureRandom.
                    - Combine the password and salt, then hash it using SHA-256.
                    - Display the encrypted password.
                - Case 4: Exit
                    - Display a thank you message.
                    - Exit the program.
    #4. End


#Project_Overview :-

The Password Generator project is a Java-based application designed to help users create strong, secure passwords, evaluate their strength, and encrypt them for safe storage. This tool is particularly useful for users who need to generate complex passwords for various online accounts or applications, ensuring their data is protected against unauthorized access.

Key Features:

    Password Generation:
        The application can generate random passwords that are a mix of uppercase and lowercase letters, numbers, and special characters. This ensures that the passwords are robust and hard to crack.

    Password Strength Check:
        Users can input their passwords to check if they meet the criteria for strength, such as containing a mix of characters, numbers, and symbols, and having a minimum length of 8 characters. The application will provide feedback on whether the password is strong or weak.

    Password Encryption:
        The application allows users to encrypt their passwords using the SHA-256 hashing algorithm combined with a unique salt. This feature is crucial for safely storing passwords, as even if the encrypted passwords are exposed, they remain secure due to the one-way nature of hashing and the randomness of the salt.

Use Cases:

    - General Users: Individuals who want to create strong passwords for their online accounts and ensure they are secure.
    - Developers: Professionals who need to generate and store encrypted passwords in their applications.
    - Security Enthusiasts: Users who are keen on understanding how password strength and encryption work and want to implement these practices in their personal or professional projects.