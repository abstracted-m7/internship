import random

def guess_the_number():

    # random number between 1 to 100
    number_to_guess = random.randint(1, 100)
    attempts = 0
    
    # Enter user name
    user = input("Enter your name : ")

    # print game details
    print(f"\nWelcome {user}!")
    print("\nI'm thinking of a number between 1 and 100.\n")
    

    # functionalites 
    while True:
        try:
            # Prompt the user to enter their guess
            guess = int(input("Enter your guess: "))
            attempts += 1
            
            if guess < number_to_guess:
                print("Too low! Try again... :( ")
            elif guess > number_to_guess:
                print("Too high! Try again... :( ")
            else:
                print(f"Hurrayyy..!! You've guessed the number {number_to_guess} correctly!")
                print(f"It took you {attempts} attempts.")
                break
        
        except ValueError:
            print("Invalid input! Please enter a valid number.")
            
# Run the game
guess_the_number()
