package com.sogeti.SoSenseiPsyche.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.sogeti.SoSenseiPsyche.model.Game.CODE_LENGTH;

public class Feedback {

    public String getFeedback(List<Character> secretCode, List<Character> guessedCode) {

        // actually this is to validate that the secretCode and the guessCode are always valid
        if (secretCode == null || guessedCode == null) {
            throw new IllegalArgumentException("Secret code or guessed code cannot be null.");
        }
        if (secretCode.size() != guessedCode.size()) {
            throw new IllegalArgumentException("Secret code and guessed code must be of the same length.");
        }
        List<Character> remainingSecretCode = new ArrayList<>(secretCode);
        List<Character> remainingGuessedCode = new ArrayList<>(guessedCode);
        StringBuilder feedback = new StringBuilder();
        for (int index = 0; index < CODE_LENGTH; index++) {
            if (guessedCode.get(index).equals(secretCode.get(index))) {
                feedback.append("o");
                remainingSecretCode.set(index, ' ');
                remainingGuessedCode.set(index, ' ');
            }
        }
        remainingSecretCode = remainingSecretCode.stream().filter(character -> character!= ' ').collect(Collectors.toList());
        remainingGuessedCode = remainingGuessedCode.stream().filter(character -> character!= ' ').collect(Collectors.toList());

        for (Character guessedChar : remainingGuessedCode) {
            if (remainingSecretCode.contains(guessedChar)) {
                feedback.append("x");
                remainingSecretCode.remove(guessedChar);
            }
        }
        return feedback.toString();
    }



}
