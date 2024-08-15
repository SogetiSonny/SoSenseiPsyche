package com.sogeti.SoSenseiPsyche.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.sogeti.SoSenseiPsyche.model.Game.CODE_LENGTH;

public class Feedback {

    public List<Character> getFeedback(List<Character> secretCode, List<Character> guessedCode) {
        List<Character> remainingSecretCode = new ArrayList<>(secretCode);
        List<Character> remainingGuessedCode = new ArrayList<>(guessedCode);
        List<Character> feedback = new ArrayList<>();
        for (int index = 0; index < CODE_LENGTH; index++) {
            if (guessedCode.get(index).equals(secretCode.get(index))) {
                feedback.add('o');
                remainingSecretCode.set(index, ' ');
                remainingGuessedCode.set(index, ' ');
            }
        }
        remainingSecretCode = remainingSecretCode.stream().filter(character -> character!= ' ').collect(Collectors.toList());
        remainingGuessedCode = remainingGuessedCode.stream().filter(character -> character!= ' ').collect(Collectors.toList());

        for (Character guessedChar : remainingGuessedCode) {
            if (remainingSecretCode.contains(guessedChar)) {
                feedback.add('x');
                remainingSecretCode.remove(guessedChar);
            }
        }
        return feedback;
    }



}
