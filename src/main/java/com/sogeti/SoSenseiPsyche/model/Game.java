package com.sogeti.SoSenseiPsyche.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Game {
    public static final int CODE_LENGTH = 4;
    public static final int MAX_ATTEMPTS = 12;
    public int attempt = 0;
    private Code secretCode;
    private String[] newGuess;
    private List<String> guesses;


    public void startGame() {
        guesses = new ArrayList<>();
        secretCode = new Code();
        System.out.println("Welcome to So Sensei Psyche!");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to crack the code.");
        System.out.println("You can choose from the following colors: " + Arrays.toString(Color.values()).replace("[", "").replace("]", ""));

        secretCode.generateCode();

        while (!isGameOver()) {
            try {
                newGuess = makeGuess(new Scanner(System.in));
                if ((newGuess == null)) {
                    System.out.println("Invalid guess. Please ensure your guess has " + CODE_LENGTH);
                    continue;
                }

                guesses.add(Arrays.toString(newGuess));
                for (String guess : guesses) {
                    System.out.println(guess.replace("[", "").replace("]", ""));
                    System.out.println("You can choose from the following colors: " + Arrays.toString(Color.values()).replace("[", "").replace("]", ""));
                }

                // feedback logic

                attempt++;

            } catch (IllegalArgumentException error) {
                System.out.println("Error: " + error.getMessage());
            }

        }
    }


    public static String[] makeGuess(Scanner scanner) {
        System.out.print("Enter your guess (e.g., RGBY): ");
        String[] guess = scanner.nextLine().toUpperCase().split(" ");

        for (int i = 0;
             i < CODE_LENGTH;
             i++) {
            if (!isCorrectColor(guess[i])) {
                System.out.println("Error: " + guess[i] + " is not a valid color. Please use one of the available colors.");
            }

            guess[i] = String.valueOf(guess[i]);
        }
        return guess;

    }


    public boolean isGameOver() {
        if (attempt == MAX_ATTEMPTS) {
            System.out.println("GAME OVER. You've used all your attempts!");
            return true;
        }

        return false;
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