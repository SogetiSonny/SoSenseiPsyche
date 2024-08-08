package com.sogeti.SoSenseiPsyche.model;

import java.util.Scanner;

class Guess {
    public static String[] getUserGuess(Scanner scanner, int codeLength) {
        System.out.print("Enter your guess (e.g., RGBY): ");
        String input = scanner.nextLine().toUpperCase().trim();
        if (input.length() != codeLength) {
            return null;
        }
        String[] guess = new String[codeLength];
        for (int i = 0; i < codeLength; i++) {
            if (!Color.isCorrectColor(input.charAt(i))) {
                return null;
            }
            guess[i] = String.valueOf(input.charAt(i));
        }
        return guess;
    }
}