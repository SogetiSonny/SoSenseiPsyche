package com.sogeti.SoSenseiPsyche.model;


import java.util.Scanner;

public class Game {
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 10;
    private final String[] COLORS = {"R", "G", "B", "Y", "O", "P"};
    private final Scanner scanner = new Scanner(System.in);
//    private final String[] secretCode;

    public Game() {
//        this.secretCode = CodeGenerator.generateSecretCode(COLORS, CODE_LENGTH);
    }

    public void play() {
        System.out.println("Welcome to Mastermind!");
        System.out.println("Available colors: R (Red), G (Green), B (Blue), Y (Yellow), O (Orange), P (Purple), W (White), S (Silver)");

//        boolean isSolved = false;
//        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
//            System.out.println("Attempt " + attempt + ":");
//            String[] guess = Guesses.getUserGuess(scanner, CODE_LENGTH, COLORS);
//            if (guess == null) {
//                System.out.println("Invalid input. Please enter a valid guess.");
//                attempt--;
//                continue;
//            }
//            int[] feedback = Feedback.getFeedback(secretCode, guess, CODE_LENGTH);
//            System.out.println("Black pegs (correct color and position): " + feedback[0]);
//            System.out.println("White pegs (correct color but wrong position): " + feedback[1]);
//            if (feedback[0] == CODE_LENGTH) {
//                isSolved = true;
//                break;
//            }
//        }
//        if (isSolved) {
//            System.out.println("Congratulations! You guessed the code.");
//        } else {
//            System.out.println("You've used all attempts. The secret code was: ");
//            for (String color : secretCode) {
//                System.out.print(color + " ");
//            }
//        }
//        scanner.close();
    }
}