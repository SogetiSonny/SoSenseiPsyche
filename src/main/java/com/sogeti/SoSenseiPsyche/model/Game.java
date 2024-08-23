package com.sogeti.SoSenseiPsyche.model;

import com.sogeti.SoSenseiPsyche.helpers.ColorMapper;
import com.sogeti.SoSenseiPsyche.record.FeedbackRecord;
import com.sogeti.SoSenseiPsyche.validations.GuessValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.sogeti.SoSenseiPsyche.model.GameboardCreator.printGameBoard;


public class Game {
    public static final int CODE_LENGTH = 4;
    private int attempt = 1;
    private int attemptsRemaining = 12;
    private List<Character> secretCode;
    private final Scanner scanner = new Scanner(System.in);
    private List<FeedbackRecord> feedbackList;
    private final Feedback feedback = new Feedback();
    GuessValidation guessValidation = new GuessValidation();

    public void startGame() {
        Code code = new Code();
        secretCode = code.generateCode();
        feedbackList = new ArrayList<>();
        System.out.println("Welcome to So Sensei Psyche!");

        // Game logic: make guess, check if game is solved, get feedback, new
        // guess or game solved or max attempts reached is game over.
        while (!isGameOver()) {
            System.out.println("You have "+ attemptsRemaining + " attempts to crack the code.");
            System.out.println("You can choose from the following colors: " + ColorMapper.getColorMapping());
            System.out.println("You can quit the game by typing 'quit'");
            userGuess();

            printGameBoard(feedbackList);

            attempt++;
            attemptsRemaining--;
        }

        System.exit(0);
    }

    private void userGuess() {
        List<Character> guessList = new ArrayList<>();
        System.out.print("Enter your guess (e.g., RGBY): ");
        String[] guess = scanner.nextLine().toUpperCase().split(" ");

        for(String guessString : guess) {
            if (guessString.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }

        while(!guessValidation.userInputIsValid(guess)) {
            System.out.print("Enter your guess (e.g., RGBY): ");
            guess = scanner.nextLine().toUpperCase().split(" ");
        }

        for (String letter : guess) {
            guessList.add(letter.charAt(0));
        }

        feedbackList.add(feedback.setFeedbackRecord(attempt, String.join(", ", guess), feedback.getFeedback(secretCode, guessList)));
    }

    private boolean isGameOver() {
        if (attemptsRemaining == 0) {
            System.out.println("GAME OVER");
            return true;
        }

        if (!feedbackList.isEmpty() && feedbackList.get(feedbackList.size() - 1).feedback().equals("oooo")) {
            System.out.println("Congratulations! You've cracked the code!");
            return true;
        }

        return false;
    }
}