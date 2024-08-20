Project Overview: Snake Game

The Snake Game is a classic arcade game implemented in Java using the Swing library for the graphical user interface. The game involves controlling a snake as it moves around the screen, consuming food items that cause the snake to grow in length. The objective is to navigate the snake without colliding with the walls or itself, while continuously increasing the score by consuming more food.
Key Features:

    Snake Movement:
        The snake is controlled using the arrow keys, with each key press changing the direction of the snake's movement. The snake moves in a grid-based environment, and its body follows the head in the direction of movement.

    Food Consumption:
        Food items appear randomly on the game board. When the snake's head reaches the food, the snake's length increases, and the player's score is incremented. A new food item then appears at a different random location.

    Collision Detection:
        The game checks for collisions with the walls or the snake's own body. If a collision is detected, the game ends, displaying a "Game Over" message along with the player's final score.

    Scoring System:
        The player's score is displayed on the screen, and it increases each time the snake consumes food. The score is shown at the top-left corner of the game window.

    Game Over Handling:
        When the game ends due to a collision, the final score is displayed, and the game exits gracefully.

    Responsive Gameplay:
        The game is responsive to user input, with smooth movement and real-time updates to the game state. The gameplay speed is controlled by a timer, ensuring a consistent and enjoyable experience.

    Graphical Interface:
        The game features a simple but effective graphical interface, with the snake and food items clearly visible on a black background. The snake's head is highlighted in green, while its body is white, and the food is red.

Use Cases:

    Entertainment: This game is perfect for users looking for a quick and fun gaming experience reminiscent of classic arcade games.
    Learning Tool: Ideal for beginner Java developers to learn about GUI development, event handling, and game logic implementation.
    Game Development: Provides a foundation for more complex game development projects, showcasing essential elements such as real-time updates, collision detection, and user interaction.