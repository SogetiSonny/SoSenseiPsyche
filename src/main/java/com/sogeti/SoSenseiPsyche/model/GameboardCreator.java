package com.sogeti.SoSenseiPsyche.model;

import java.util.List;

public class GameboardCreator {

    public static void print(int attemptNumber, List<List<Character>> guessedCode, List<List<Character>> feedback) {
        for (int idx = 1; idx <= attemptNumber; idx++) {
            System.out.println("| " + String.format("%-" + 2 + "s", idx) + " | " + fromArrayToFormattedString(guessedCode.get(idx - 1)) + " | " + fromArrayToFormattedString(feedback.get(idx - 1)) + " | ");
        }
    }

    public static String fromArrayToFormattedString(List<Character> listToFormat) {
        String string = listToFormat.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        return String.format("%-" + 7 + "s", string);
    }
}
