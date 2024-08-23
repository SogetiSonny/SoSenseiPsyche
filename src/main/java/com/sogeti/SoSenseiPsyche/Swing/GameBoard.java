package com.sogeti.SoSenseiPsyche.Swing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends JPanel {
    private DropTargetPanel[][] guessSlots; // 2D array for guess slots
    private JPanel[][] feedbackSlots; // 2D array for feedback slots (now using JPanel for flexibility)
    private int currentRow = 0;

    public GameBoard(int rows, List<Color> secretCode) {
        setLayout(new GridLayout(rows, 1, 10, 10)); // 12 rows with padding

        guessSlots = new DropTargetPanel[rows][4];
        feedbackSlots = new JPanel[rows][4];

        for (int i = 0; i < rows; i++) {
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

            // Create 4 guess slots for each row
            for (int j = 0; j < 4; j++) {
                guessSlots[i][j] = new DropTargetPanel();
                rowPanel.add(guessSlots[i][j]);
            }

            // Create 4 feedback slots for each row
            for (int j = 0; j < 4; j++) {
                feedbackSlots[i][j] = new JPanel();
                feedbackSlots[i][j].setPreferredSize(new Dimension(20, 20));
                feedbackSlots[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                rowPanel.add(feedbackSlots[i][j]);
            }

            add(rowPanel); // Add the row to the game board
        }
    }

    public boolean isRowFilled() {
        for (int i = 0; i < 4; i++) {
            if (guessSlots[currentRow][i].getBackground().equals(Color.WHITE)) {
                return false;
            }
        }
        return true;
    }

    public void moveToNextRow() {
        currentRow++;
    }

    public List<Color> getCurrentGuess() {
        List<Color> guess = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            guess.add(guessSlots[currentRow][i].getBackground());
        }
        return guess;
    }

    public void setFeedback(List<Character> feedback) {
        for (int i = 0; i < feedback.size(); i++) {
            if (feedback.get(i) == 'o') {
                feedbackSlots[currentRow][i].setBackground(Color.BLACK); // Black for exact match
            } else if (feedback.get(i) == 'x') {
                feedbackSlots[currentRow][i].setBackground(Color.WHITE); // White for correct color, wrong position
            }
        }
    }
}
