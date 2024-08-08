package com.sogeti.SoSenseiPsyche.model;

import java.util.Scanner;
import static com.sogeti.SoSenseiPsyche.model.Game.CODE_LENGTH;


public class Guess {

    public static String[] getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess (e.g., RGBY): ");
        String input = scanner.nextLine().toUpperCase().trim();
        if (input.length() != CODE_LENGTH) {
            return null;
        }
        String[] guess = new String[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (!Color.isCorrectColor(input.charAt(i))) {
                return null;
            }
            guess[i] = String.valueOf(input.charAt(i));
        }
        return guess;
    }
}