package com.sogeti.SoSenseiPsyche.model;

import com.sogeti.SoSenseiPsyche.helpers.ColorMapper;
import com.sogeti.SoSenseiPsyche.record.FeedbackRecord;
import com.sogeti.SoSenseiPsyche.validations.GuessValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.sogeti.SoSenseiPsyche.model.GameboardCreator.printGameBoard;

public class Game {
    public static final int CODE_LENGTH = 4;
    private final Scanner scanner = new Scanner(System.in);
    private final Feedback feedback = new Feedback();
    GuessValidation guessValidation = new GuessValidation();
    private int attempt = 1;
    private int attemptsRemaining = 12;
    private List<Character> secretCode;
    private List<FeedbackRecord> feedbackList;

    public void startGame() {
        Code code = new Code();
        secretCode = code.generateCode();
        feedbackList = new ArrayList<>();
        System.out.println("Welcome to So Sensei Psyche!");

        // Game logic: make guess, check if game is solved, get feedback, new
        // guess or game solved or max attempts reached is game over.
        while (!isGameOver()) {
            System.out.println("You have " + attemptsRemaining + " attempts to crack the code.");
            System.out.println("You can choose from the following colors: " + ColorMapper.getColorMapping());
            System.out.println("You can quit the game by typing 'quit'");
            userGuess();

            printGameBoard(feedbackList);

            attempt++;
            attemptsRemaining--;
            if (attempt > 13) {  // true at Integer.MAX_VALUE +1
                break;
            }
        }

        System.exit(0);
    }

    private void userGuess() {
        List<Character> guessList = new ArrayList<>();
        System.out.print("Enter your guess (e.g., R G B Y or Red Green Blue Yellow): ");
        String[] guess = scanner.nextLine().toUpperCase().split(" ");

        for (String guessString : guess) {
            if (guessString.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }

        while (!guessValidation.userInputIsValid(guess)) {
            System.out.print("Enter your guess (e.g., R G B Y or Red Green Blue Yellow): ");
            guess = scanner.nextLine().toUpperCase().split(" ");
        }

        for (String letter : guess) {
            guessList.add(letter.charAt(0));
        }
        feedbackList.add(feedback.setFeedbackRecord(attempt, guessList.toString(), feedback.getFeedback(secretCode, guessList)));
    }

    private boolean isGameOver() {
        if (attemptsRemaining == 0) {
            System.out.println("GAME OVER");
            playAgain();
        }

        if (!feedbackList.isEmpty() && feedbackList.get(feedbackList.size() - 1).feedback().equals("oooo")) {
            System.out.println("Congratulations! You've cracked the code!");
            playAgain();
        }
        return false;
    }

    private boolean playAgain() {
        System.out.println("Would you like to play again? (Y/N)");
        String playAgain = scanner.nextLine();
        if (playAgain.equalsIgnoreCase("Y")) {
            attempt = 1;
            attemptsRemaining = 12;
            startGame();
        } else if (playAgain.equalsIgnoreCase("N")) {
            System.out.println("Goodbye!");
            System.exit(0);
        } else if (!playAgain.equalsIgnoreCase("Y") || !playAgain.equalsIgnoreCase("N")) {
            System.out.println("Invalid input. Please enter Y or N.");
            playAgain();
        }
        return false;
    }
}