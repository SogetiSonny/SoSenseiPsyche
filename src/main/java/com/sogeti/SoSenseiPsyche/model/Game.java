package com.sogeti.SoSenseiPsyche.model;


import java.util.Scanner;

public class Game {
    public static final int CODE_LENGTH = 4;

// for testing purpose

    public void startGame() {
        System.out.println("Welcome to Mastermind!");
        System.out.println("Available colors: ");

        for (Color color : Color.values()) {
            System.out.println(color.name() + " (" + color.name().charAt(0) + ")");
        }
        makeGuess();
    }

    public static String[] makeGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess (e.g., RGBY): ");
        String input = scanner.nextLine().toUpperCase().trim();
        if (input.length() != CODE_LENGTH) {
            System.out.println("Please enter 4 characters.");
            makeGuess();
        }
        String[] guess = new String[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (!isCorrectColor(input.charAt(i))) {
                System.out.println("Please enter valid colors");
                makeGuess();
                return null;
            }
            guess[i] = String.valueOf(input.charAt(i));
        }
        return guess;
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