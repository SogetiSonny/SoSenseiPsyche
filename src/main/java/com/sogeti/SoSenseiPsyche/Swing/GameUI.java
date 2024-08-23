package com.sogeti.SoSenseiPsyche.Swing;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GameUI extends JFrame {
    private GameBoard gameBoard;
    private JLabel attemptsLabel;
    private JButton submitButton;
    private JPanel pinPanel; // Panel for colored pins
    private List<Color> secretCode; // The secret code for the game

    public GameUI() {
        setTitle("Mastermind Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Generate a random secret code (for simplicity, using fixed colors here)
        secretCode = Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);

        // Set full-screen window
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Top panel for displaying attempts remaining
        JPanel topPanel = new JPanel();
        attemptsLabel = new JLabel("Attempts remaining: 12");
        topPanel.add(attemptsLabel);
        add(topPanel, BorderLayout.NORTH);

        // Center panel to hold and center the game board
        JPanel centerPanel = new JPanel(new GridBagLayout());
        gameBoard = new GameBoard(12, secretCode); // Create a game board with 12 rows (attempts)
        gameBoard.setPreferredSize(new Dimension(800, 600)); // Set a preferred size for the game board
        gameBoard.setMinimumSize(new Dimension(800, 600)); // Ensure minimum size
        centerPanel.add(gameBoard);
        add(centerPanel, BorderLayout.CENTER);

        // Right panel for the submit button
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        submitButton = new JButton("Submit Guess");
        submitButton.setEnabled(false);
        submitButton.addActionListener(e -> submitGuess());
        rightPanel.add(submitButton);
        add(rightPanel, BorderLayout.EAST);

        // Bottom panel to hold the colored pins
        pinPanel = createPinPanel();
        add(pinPanel, BorderLayout.SOUTH);

        // Enable the submit button when the current row is filled
        new Timer(500, e -> {
            if (gameBoard.isRowFilled()) {
                submitButton.setEnabled(true);
            } else {
                submitButton.setEnabled(false);
            }
        }).start();

        setVisible(true);
    }

    private JPanel createPinPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Center aligned

        // Create colored pins and add them to the panel
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.PINK};
        for (Color color : colors) {
            ColoredPin pin = new ColoredPin(color);
            panel.add(pin);
        }

        return panel;
    }

    private void submitGuess() {
        List<Color> currentGuess = gameBoard.getCurrentGuess();
        List<Character> feedback = FeedbackCalculator.calculateFeedback(secretCode, currentGuess);
        gameBoard.setFeedback(feedback);
        gameBoard.moveToNextRow();
        submitButton.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameUI());
    }
}
