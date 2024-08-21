package com.sogeti.SoSenseiPsyche.validations;

import com.sogeti.SoSenseiPsyche.model.Color;

import static com.sogeti.SoSenseiPsyche.helpers.ColorMapper.doesColorExist;

public class GuessValidation {
    public boolean userInputIsValid(String[] guess) {
        if (guess.length != 4) {
            System.out.println("Invalid input. Please enter a 4-letter code.");
            return false;
        }

        for (String letter : guess) {
            if (!doesColorExist(letter.charAt(0))) {
                System.out.printf("Invalid input. %s is not a valid color.%n", letter);
                return false;
            }
        }
        return true;
    }
}
