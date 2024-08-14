package com.sogeti.SoSenseiPsyche.model;


import java.util.List;
import java.util.Scanner;

public class Game {
    public static final int CODE_LENGTH = 4;
    public static final int MAX_ATTEMPTS = 12;
    public int attempt = 0;
    private Code secretCode;
    private List<Guess> guesses;

// for testing purpose

    public void startGame() {
        secretCode = new Code();
        System.out.println("Welcome to So Sensei Psyche!");


        // Game logic: make guess, check if game is solved, get feedback, new
        // guess or game solved or max attempts reached is game over.
        while (!isGameOver()) {
            makeGuess(new Scanner(System.in));

            // feedback logic

            attempt++;
        }
    }

    // TODO: return type should be Feedback. Adjustments need to be made when
    //  class Feedback and logic is finished.
    public static String[] makeGuess(Scanner scanner) {
        System.out.print("Enter your guess (e.g., RGBY): ");
        String input = scanner.nextLine().toUpperCase().trim();
        if (input.length() != CODE_LENGTH) {
            return null;
        }
        String[] guess = new String[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (!isCorrectColor(input.charAt(i))) {
                return null;
            }
            guess[i] = String.valueOf(input.charAt(i));
        }
        return guess;
    }

    public boolean isGameOver() {
        if (attempt == MAX_ATTEMPTS) {
            System.out.println("GAME OVER");
            return true;
        }
        return false;
    }

    public static boolean isCorrectColor(char c) {
        for (Color color : Color.values()) {
            if (color.name().charAt(0) == c) {
                return true;
            }
        }
        return false;
    }
}