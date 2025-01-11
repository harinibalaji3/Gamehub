import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameHub {
    private JFrame frame;
    private JPanel panel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameHub();
        });
    }

    public GameHub() {
        frame = new JFrame("GameHub");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Create the main panel for the game menu
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));  // Added spacing between buttons

        // Create buttons for games
        JButton snakeButton = new JButton("Snake Game");
        JButton ticTacToeButton = new JButton("Tic-Tac-Toe");

        // Custom font for the buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        snakeButton.setFont(buttonFont);
        ticTacToeButton.setFont(buttonFont);

        // Add action listeners to buttons
        snakeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startSnakeGame();
            }
        });

        ticTacToeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTicTacToe();
            }
        });

        // Add buttons to panel
        panel.add(snakeButton);
        panel.add(ticTacToeButton);

        // Set layout of frame and add the panel
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        // Make frame visible
        frame.setVisible(true);
    }

    private void startSnakeGame() {
        // Remove all existing components from the frame
        frame.getContentPane().removeAll();
        frame.repaint();

        // Create Snake game instance
        Snakes snakeGame = new Snakes(600, 600);

        // Add the snake game component to the frame
        frame.add(snakeGame, BorderLayout.CENTER);

        // Add the "Back to Main Menu" button
        JButton backButton = new JButton("Back to Main Menu");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.addActionListener(e -> returnToMainMenu());

        // Add the back button to the frame
        frame.add(backButton, BorderLayout.SOUTH);

        // Refresh the frame to display the Snake game
        frame.revalidate();
        frame.repaint();

        // Ensure the Snake game panel gets focus to listen for key events
        snakeGame.requestFocusInWindow();
    }

    private void startTicTacToe() {
        // Remove all existing components from the frame
        frame.getContentPane().removeAll();
        frame.repaint();

        // Create TicTacToe game instance
        TicTacToe ticTacToe = new TicTacToe();

        // Add the TicTacToe game component to the frame
        frame.add(ticTacToe, BorderLayout.CENTER);

        // Add the "Back to Main Menu" button
        JButton backButton = new JButton("Back to Main Menu");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.addActionListener(e -> returnToMainMenu());

        // Add the back button to the frame
        frame.add(backButton, BorderLayout.SOUTH);

        // Refresh the frame to display the TicTacToe game
        frame.revalidate();
        frame.repaint();
    }

    private void returnToMainMenu() {
        // Remove current game components
        frame.getContentPane().removeAll();
        frame.repaint();

        // Add the main menu panel again
        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}
