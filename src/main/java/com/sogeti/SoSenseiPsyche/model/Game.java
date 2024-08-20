package com.sogeti.SoSenseiPsyche.model;



import java.util.ArrayList;
import java.util.Arrays;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Game {
    public static final int CODE_LENGTH = 4;
    public static final int MAX_ATTEMPTS = 12;
    public int attempt = 0;
    private Code secretCode;
    private String[] newGuess;
    private List<String> guesses;

// for testing purpose
    Feedback feedback = new Feedback();
    Code code = new Code();
    List<Character> secretCode = code.getCode();

    public void startGame() {
        guesses = new ArrayList<>();
        secretCode = new Code();
        System.out.println("Welcome to So Sensei Psyche!");
        System.out.println("You have "+ MAX_ATTEMPTS + " attempts to crack the code.");
        System.out.println("You can choose from the following colors: " + Arrays.toString(Color.values()).replace("[", "").replace("]", ""));

        secretCode.generateCode();

        // Game logic: make guess, check if game is solved, get feedback, new
        // guess or game solved or max attempts reached is game over.
        while (!isGameOver()) {
            newGuess = makeGuess(new Scanner(System.in));
            guesses.add(Arrays.toString(newGuess));
            for (String guess : guesses) {
                System.out.println(guess.replace("[", "").replace("]", ""));
                System.out.println("You can choose from the following colors: " + Arrays.toString(Color.values()).replace("[", "").replace("]", ""));
            }

            // feedback logic

            attempt++;
        }
    }

    // TODO: return type should be Feedback. Adjustments need to be made when
    //  class Feedback and logic is finished.
    public static String[] makeGuess(Scanner scanner) {
        System.out.print("Enter your guess (e.g., R G B Y): ");
        String[] guess = scanner.nextLine().toUpperCase().split(" ");

        if (guess.length != CODE_LENGTH) {
            return null;
        }

        for (int i = 0; i < CODE_LENGTH; i++) {
            if (!isCorrectColor(guess[i])) {

                return null;
            } else {
                guessedCode.add(input.charAt(i));
            }

            guess[i] = String.valueOf(guess[i]);
        }

        return guessedCode;

    }


    public boolean isGameOver() {
       return (attempt == MAX_ATTEMPTS) ? (System.out.println("GAME OVER") == null && true) : false;
    }

    public static boolean isCorrectColor(String c) {

        for (Color color : Color.values()) {
            if (color.name().startsWith(c)) {
                return true;
            }
        }
        return false;
    }

}