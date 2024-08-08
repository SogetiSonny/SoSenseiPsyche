package com.sogeti.SoSenseiPsyche.model;

import java.util.Scanner;

public class Guesses {

    private static final String[] COLORS = {"R", "G", "B", "Y", "O", "P", "W", "S"};
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 12;
    Scanner scanner = new Scanner(System.in);


    public void play() {
        System.out.println("Welcome to Mastermind!");
        System.out.println("Available colors: R (Red), G (Green), B (Blue), Y (Yellow), O (Orange), P (Purple)");

        boolean isSolved = false;
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.println("Attempt " + attempt + ":");
            String[] guess = getUserGuess();
            if (guess == null) {
                System.out.println("Invalid input. Please enter a valid guess.");
                attempt--;
                continue;
            }
//            int[] feedback = getFeedback(secretCode, guess);
//            System.out.println("Black pegs (correct color and position): " + feedback[0]);
//            System.out.println("White pegs (correct color but wrong position): " + feedback[1]);
//            if (feedback[0] == CODE_LENGTH) {
//                isSolved = true;
//                break;
//            }
        }
        if (isSolved) {
            System.out.println("Congratulations! You guessed the code.");
        } else {
//            System.out.println("You've used all attempts. The secret code was: ");
//            for (String color : secretCode) {
//                System.out.print(color + " ");
//            }
        }
        scanner.close();
    }


    private String[] getUserGuess() {
        System.out.print("Enter your guess (e.g., RGBY): ");
        String input = scanner.nextLine().toUpperCase().trim();
        if (input.length() != CODE_LENGTH) {
            return null;
        }
        String[] guess = new String[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (!isValidColor(input.charAt(i))) {
                return null;
            }
            guess[i] = String.valueOf(input.charAt(i));
        }
        return guess;
    }

    private boolean isValidColor(char c) {
        for (String color : COLORS) {
            if (color.charAt(0) == c) {
                return true;
            }
        }
        return false;
    }

}


