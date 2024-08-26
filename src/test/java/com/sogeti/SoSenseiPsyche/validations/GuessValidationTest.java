package com.sogeti.SoSenseiPsyche.validations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuessValidationTest {

    @Test
    public void givenValidGuess_whenValidatingUserInput_thenItShouldBeConsideredValid() {
        // Given: We have a valid guess with 4 valid color initials or names
        GuessValidation validation = new GuessValidation();
        String[] validGuess = {"R", "G", "B", "Y"};

        // When: We validate the user input using the GuessValidation class
        boolean isValid = validation.userInputIsValid(validGuess);

        // Then: The guess should be considered valid since it meets the criteria
        assertTrue(isValid, "The guess should be valid for the input RGBY");
    }

    @Test
    public void givenInvalidGuessLength_whenValidatingUserInput_thenItShouldBeConsideredInvalid() {
        // Given: We have an invalid guess with fewer than 4 characters
        GuessValidation validation = new GuessValidation();
        String[] invalidGuess = {"R", "G", "B"};

        // When: We validate the user input using the GuessValidation class
        boolean isValid = validation.userInputIsValid(invalidGuess);

        // Then: The guess should be considered invalid due to incorrect length
        assertFalse(isValid, "The guess should be invalid for input length not equal to 4");
    }

    @Test
    public void givenGuessWithInvalidCharacter_whenValidatingUserInput_thenItShouldBeConsideredInvalid() {
        // Given: We have an invalid guess with a character that does not represent any color
        GuessValidation validation = new GuessValidation();
        String[] invalidGuess = {"R", "G", "X", "Y"};

        // When: We validate the user input using the GuessValidation class
        boolean isValid = validation.userInputIsValid(invalidGuess);

        // Then: The guess should be considered invalid due to an unrecognized character
        assertFalse(isValid, "The guess should be invalid if it contains characters not representing any color");
    }
}
