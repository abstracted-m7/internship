1. Importing the Random Module:

import random

    The random module is imported to generate random numbers within a specified range.

2. Defining the Function:

def guess_the_number():

    A function named guess_the_number is defined to encapsulate the game's logic.

3. Generating a Random Number:

number_to_guess = random.randint(1, 100)
attempts = 0

    number_to_guess stores a random integer between 1 and 100 (inclusive) using random.randint(1, 100).
    attempts is initialized to 0 to keep track of the number of guesses made by the user.

4. Getting the User's Name:

user = input("Enter your name : ")

    The player is prompted to enter their name, which is stored in the variable user.

5. Displaying Game Details:

print(f"\nWelcome {user}!")
print("\nI'm thinking of a number between 1 and 100.\n")

    A welcome message is displayed using the player's name, followed by information about the game.

6. Main Game Loop:

while True:

    A while True loop is used to keep the game running until the player correctly guesses the number.

7. Handling User Input and Game Logic:

try:
    guess = int(input("Enter your guess: "))
    attempts += 1

    Inside the loop, the player is prompted to enter a guess, which is converted to an integer.
    The attempts counter is incremented by 1 with each guess.

8. Checking the Guess:

if guess < number_to_guess:
    print("Too low! Try again... :( ")
elif guess > number_to_guess:
    print("Too high! Try again... :( ")
else:
    print(f"Hurrayyy..!! You've guessed the number {number_to_guess} correctly!")
    print(f"It took you {attempts} attempts.")
    break

    The code checks if the guess is less than, greater than, or equal to the number_to_guess.
        If the guess is too low, a "Too low!" message is displayed.
        If the guess is too high, a "Too high!" message is displayed.
        If the guess is correct, a congratulatory message is shown, including the number of attempts made. The loop is then exited using break.

9. Handling Invalid Input:

except ValueError:
    print("Invalid input! Please enter a valid number.")

    If the user inputs something that isn't a number, a ValueError is raised, and the game prompts the user to enter a valid number.

10. Running the Game:


guess_the_number()

    Finally, the guess_the_number function is called to start the game.