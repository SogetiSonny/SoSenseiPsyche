package com.sogeti.SoSenseiPsyche.validations;

import com.sogeti.SoSenseiPsyche.model.Color;

import static com.sogeti.SoSenseiPsyche.helpers.ColorMapper.doesColorExist;

public class GuessValidation {
    public boolean userInputIsValid(String[] guess) {
        if (guess.length != 4) {
            System.out.println("Invalid input. Please enter a 4-letter code.");
            return false;
        }

        for (String color : guess) {
            if (!doesColorExist(color)) {
                System.out.printf("Please enter valid color names or valid color first letters. ");
                return false;
            }
        }
        return true;
    }
}
