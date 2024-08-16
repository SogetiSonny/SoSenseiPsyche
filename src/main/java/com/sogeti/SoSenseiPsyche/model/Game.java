package com.sogeti.SoSenseiPsyche.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final int CODE_LENGTH = 4;

// for testing purpose
    Feedback feedback = new Feedback();
    SecretCode code = new SecretCode();
    List<Character> secretCode = code.getSecretCode();
    List<List<Character>> feedbackHistory = new ArrayList<>();
    List<List<Character>> guessesHistory = new ArrayList<>();

    int attemptNumber = 1;
    int maxNumberOfAttempts = 10;

    public void startGame() {
        System.out.println("secretcode" + secretCode);
        System.out.println("Welcome to Mastermind!");
        System.out.println("Available colors: ");

        for (Color color : Color.values()) {
            System.out.println(color.name() + " (" + color.name().charAt(0) + ")");
        }
        //displaying fot test purpose
        System.out.println(secretCode);

        while (attemptNumber <= maxNumberOfAttempts) {
            List<Character> guessedCode = makeGuess();
            List<Character> feedbackToStore = feedback.getFeedback(guessedCode, secretCode);
            feedbackHistory.add(feedbackToStore);
            guessesHistory.add(guessedCode);

            for (int i = 1; i <= attemptNumber; i++) {
                System.out.println("| " + String.format("%-" + 2 + "s", i) + " | " + formatList(guessesHistory.get(i - 1)) + " | " + formatList(feedbackHistory.get(i - 1)) + " | ");
            }
            attemptNumber++;
        }

    }

    public static String formatList(List<Character> listToFormat) {
        String string = listToFormat.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        return String.format("%-" + 7 + "s", string);
    }

    public static List<Character> makeGuess() {
        List<Character> guessedCode = new ArrayList<>();
        boolean isValidGuess = false;
        while (!isValidGuess) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your guess (e.g., RGBY): ");
            String input = scanner.nextLine().toUpperCase().trim();
            if (input.length() != CODE_LENGTH) {
                System.out.println("Please enter 4 characters.");
            } else {
                for (int i = 0; i < CODE_LENGTH; i++) {
                    if (!isCorrectColor(input.charAt(i))) {
                        System.out.println("Please enter valid colors");
                    } else {
                        guessedCode.add(input.charAt(i));
                        isValidGuess = true;
                    }
                }
            }
        }
        return guessedCode;
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