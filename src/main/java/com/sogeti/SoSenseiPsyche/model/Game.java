package com.sogeti.SoSenseiPsyche.model;

import com.sogeti.SoSenseiPsyche.helpers.ColorMapper;
import com.sogeti.SoSenseiPsyche.validations.GuessValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Game {
    public static final int CODE_LENGTH = 4;
    private int attemptsRemaining = 2;
    private List<String> guesses;
    private List<Character> secretCode;
    private final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        Code code = new Code();
        guesses = new ArrayList<>();
        secretCode = code.generateCode();

        System.out.println("Welcome to So Sensei Psyche!");

        //For testing purposes we show the secret code
        System.out.println(secretCode);

        // Game logic: make guess, check if game is solved, get feedback, new
        // guess or game solved or max attempts reached is game over.
        while (!isGameOver()) {
            System.out.println("You have "+ attemptsRemaining + " attempts to crack the code.");
            System.out.println("You can choose from the following colors: " + ColorMapper.getColorMapping());
            userGuess();
            for (String guess : guesses) {
                System.out.println(guess.replace("[", "").replace("]", ""));
            }

            attemptsRemaining--;
        }
    }

    private void userGuess() {
        System.out.print("Enter your guess (e.g., RGBY): ");
        String[] guess = scanner.nextLine().toUpperCase().split(" ");
        GuessValidation guessValidation = new GuessValidation();

        while(!guessValidation.userInputIsValid(guess)) {
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

    private boolean isGameOver() {
        if (attemptsRemaining == 0) {
            System.out.println("GAME OVER");
            return true;
        }
        return false;
    }
}