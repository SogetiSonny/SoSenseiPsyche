package com.sogeti.SoSenseiPsyche.model;


import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Game {
    public static final int CODE_LENGTH = 4;

// for testing purpose
    Feedback feedback = new Feedback();
    Code code = new Code();
    List<Character> secretCode = code.getCode();

    public void startGame() {
        System.out.println("secretcode" + secretCode);
        System.out.println("Welcome to Mastermind!");
        System.out.println("Available colors: ");

        for (Color color : Color.values()) {
            System.out.println(color.name() + " (" + color.name().charAt(0) + ")");
        }
        System.out.println(secretCode);
        List<Character> guessedCode = makeGuess();
        System.out.println(feedback.getFeedback(guessedCode, secretCode));

    }

    public static List<Character> makeGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess (e.g., RGBY): ");
        String input = scanner.nextLine().toUpperCase().trim();
        List<Character> guessedCode = new ArrayList<>();

        if (input.length() != CODE_LENGTH) {
            System.out.println("Please enter 4 characters.");
            makeGuess();
        }

        for (int i = 0; i < CODE_LENGTH; i++) {
            if (!isCorrectColor(input.charAt(i))) {
                System.out.println("Please enter valid colors");
                makeGuess();
                return null;
            } else {
                guessedCode.add(input.charAt(i));
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