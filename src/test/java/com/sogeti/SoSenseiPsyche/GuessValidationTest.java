package com.sogeti.SoSenseiPsyche;

import com.sogeti.SoSenseiPsyche.validations.GuessValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessValidationTest {

    @Test
    public void givenValidGuess_whenValidatingUserInput_thenItShouldBeConsideredValid() {
        // Given: We have a valid guess input that follows the correct format
        GuessValidation validation = new GuessValidation();
        String[] validGuess = {"R", "G", "B", "Y"};

        // When: We validate the user input using the GuessValidation class
        boolean isValid = validation.userInputIsValid(validGuess);

        // Then: The guess should be considered valid since it meets the criteria
        assertTrue(isValid, "The guess should be valid for the input RGBY");
    }

    @Test
    public void givenInvalidGuessLength_whenValidatingUserInput_thenItShouldBeConsideredInvalid() {
        // Given: We have a guess input that does not have the correct number of characters
        GuessValidation validation = new GuessValidation();
        String[] invalidGuess = {"R", "G", "B"};

        // When: We validate the user input using the GuessValidation class
        boolean isValid = validation.userInputIsValid(invalidGuess);

        // Then: The guess should be considered invalid because it does not have exactly 4 characters
        assertFalse(isValid, "The guess should be invalid for input length not equal to 4");
    }

    @Test
    public void givenGuessWithInvalidCharacter_whenValidatingUserInput_thenItShouldBeConsideredInvalid() {
        // Given: We have a guess input that includes a character not associated with any valid color
        GuessValidation validation = new GuessValidation();
        String[] invalidGuess = {"R", "G", "X", "Y"};

        // When: We validate the user input using the GuessValidation class
        boolean isValid = validation.userInputIsValid(invalidGuess);

        // Then: The guess should be considered invalid because it contains an unrecognized color character
        assertFalse(isValid,
                "The guess should be invalid if it contains characters not representing any color");
    }
}
