package com.sogeti.SoSenseiPsyche.model;

import com.sogeti.SoSenseiPsyche.helpers.ColorMapper;
import com.sogeti.SoSenseiPsyche.validations.GuessValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final int CODE_LENGTH = 4;
    private int attemptsRemaining = 12;
    private List<String> guesses;
    private List<Character> secretCode;
    private final Scanner scanner = new Scanner(System.in);

    public int getAttemptsRemaining() {
        return attemptsRemaining;
    }

    public List<Character> getSecretCode() {
        return secretCode;
    }

    public void decrementAttempts() {
        attemptsRemaining--;
    }

    public boolean getIsGameOver() {
        return isGameOver();
    }

    public void startGame() {
        Code code = new Code();
        guesses = new ArrayList<>();
        secretCode = code.generateCode();

        // For testing purposes we show the secret code
        System.out.println(secretCode);
    }

    private void userGuess() {
        System.out.print("Enter your guess (e.g., RGBY): ");
        String[] guess = scanner.nextLine().toUpperCase().split(" ");

        for (String guessString : guess) {
            if (guessString.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }

        GuessValidation guessValidation = new GuessValidation();

        while (!guessValidation.userInputIsValid(guess)) {
            System.out.print("Enter your guess (e.g., RGBY): ");
            guess = scanner.nextLine().toUpperCase().split(" ");
        }

        Feedback feedback = new Feedback();
        List<Character> guessList = new ArrayList<>();

        for (String letter : guess) {
            guessList.add(letter.charAt(0));
        }

        guesses.add(Arrays.toString(guess));
        System.out.println(feedback.getFeedback(secretCode, guessList));
    }

    public boolean isGameOver() {
        if (attemptsRemaining == 0) {
            System.out.println("GAME OVER");
            return true;
        }
        return false;
    }
}