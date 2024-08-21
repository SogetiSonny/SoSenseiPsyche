package com.sogeti.SoSenseiPsyche.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.sogeti.SoSenseiPsyche.model.Game.CODE_LENGTH;

public class Feedback {

    public String getFeedback(List<Character> secretCode, List<Character> guessedCode) {
        StringBuilder feedback = new StringBuilder();
        for (int index = 0; index < CODE_LENGTH; index++) {
            if (guessedCode.get(index).equals(secretCode.get(index))) {
                feedback.append("O");
            } else if (secretCode.contains(guessedCode.get(index))) {
                feedback.append("X");
            } else {
                feedback.append(" ");
            }
        }

        return feedback.toString();
    }

}
