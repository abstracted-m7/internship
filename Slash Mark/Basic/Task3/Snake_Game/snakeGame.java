package Basic.Task3.Snake_Game;


// // package Basic.Task3.Snake_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class snakeGame extends JFrame {

    private static final int broderWidth = 300;
    private static final int broderHeight = 300;
    private static final int dotSize = 10; // Size of the snake's body and food
    private static final int AllDots = 900;
    private static final int randomPosition = 29;
    private static final int Delay = 140;

    private final int[] x = new int[AllDots];
    private final int[] y = new int[AllDots];

    private int dots; // Length of the snake
    private int foodX;
    private int foodY;
    private int score; // Score counter

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Board board;

    public snakeGame() {
        initGame();
    }

    private void initGame() {
        board = new Board();
        add(board);
        setResizable(false);
        pack();

        setTitle("Snake Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startGame();
    }

    private void startGame() {
        dots = 3;
        score = 0; // Initialize score

        for (int i = 0; i < dots; i++) {
            x[i] = 50 - i * dotSize;
            y[i] = 50;
        }

        locateFood();

        timer = new Timer(Delay, new GameCycle());
        timer.start();
    }

    private void locateFood() {
        int r = (int) (Math.random() * randomPosition);
        foodX = ((r * dotSize));

        r = (int) (Math.random() * randomPosition);
        foodY = ((r * dotSize));
    }

    private void checkFood() {
        if ((x[0] == foodX) && (y[0] == foodY)) {
            dots++;
            score++; // Increase score when food is eaten
            locateFood();
        }
    }

    private void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (leftDirection) {
            x[0] -= dotSize;
        }

        if (rightDirection) {
            x[0] += dotSize;
        }

        if (upDirection) {
            y[0] -= dotSize;
        }

        if (downDirection) {
            y[0] += dotSize;
        }
    }

    private void checkCollision() {
        for (int i = dots; i > 0; i--) {
            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                inGame = false;
            }
        }

        if (y[0] >= broderHeight || y[0] < 0 || x[0] >= broderWidth || x[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    private void gameOver(Graphics g) {
        String msg = "Game Over....!!";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.red);
        g.setFont(small);
        g.drawString(msg, (broderWidth - metr.stringWidth(msg)) / 2, broderHeight / 2);

        System.out.println("Your score is : "+score);
        System.out.println("Exiting from Game...!!");
    }

    private class Board extends JPanel {

        public Board() {
            setBackground(Color.black);
            setPreferredSize(new Dimension(broderWidth, broderHeight));
            setFocusable(true);
            addKeyListener(new TAdapter());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (inGame) {
                g.setColor(Color.red);
                g.fillRect(foodX, foodY, dotSize, dotSize);

                for (int i = 0; i < dots; i++) {
                    if (i == 0) {
                        g.setColor(Color.green);
                    } else {
                        g.setColor(Color.white);
                    }
                    g.fillRect(x[i], y[i], dotSize, dotSize);
                }

                drawScore(g); // Draw the score

                Toolkit.getDefaultToolkit().sync();
            } else {
                gameOver(g);
            }
        }

        private void drawScore(Graphics g) {
            String scoreText = "Score: " + score;
            Font scoreFont = new Font("Helvetica", Font.BOLD, 14);
            g.setColor(Color.white);
            g.setFont(scoreFont);
            g.drawString(scoreText, 5, 15); // Positioning the score at the top-left corner
        }
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (inGame) {
                checkFood();
                checkCollision();
                move();
            }

            board.repaint();
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame ex = new snakeGame();
            ex.setVisible(true);
        });
    }
}

