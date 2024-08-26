package com.sogeti.SoSenseiPsyche.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedbackTest {

    @Test
    public void givenExactMatch_whenGetFeedback_thenReturnFourO() {
        // Given a secret code and a guessed code that are exactly the same
        List<Character> secretCode = Arrays.asList('R', 'G', 'B', 'Y');
        List<Character> guessedCode = Arrays.asList('R', 'G', 'B', 'Y');

        Feedback feedback = new Feedback();

        // When we get feedback
        String result = feedback.getFeedback(secretCode, guessedCode);

        // Then the feedback should be "oooo"
        assertEquals("oooo", result,
                "Feedback should be 'oooo' for an exact match.");
    }

    @Test
    public void givenPartialMatch_whenGetFeedback_thenReturnTwoOAndTwoX() {
        // Given a secret code and a guessed code where two colors are correct in the right positions and two correct in wrong positions
        List<Character> secretCode = Arrays.asList('R', 'G', 'B', 'Y');
        List<Character> guessedCode = Arrays.asList('R', 'B', 'G', 'Y');

        Feedback feedback = new Feedback();

        // When we get feedback
        String result = feedback.getFeedback(secretCode, guessedCode);

        // Then the feedback should be "ooxx"
        assertEquals("ooxx", result,
                "Feedback should be 'ooxx' when two colors are correct in the right positions and two in the wrong positions.");
    }

    @Test
    public void givenNoMatch_whenGetFeedback_thenReturnEmptyString() {
        // Given a secret code and a guessed code with no correct colors
        List<Character> secretCode = Arrays.asList('R', 'G', 'B', 'Y');
        List<Character> guessedCode = Arrays.asList('W', 'O', 'P', 'S');

        Feedback feedback = new Feedback();

        // When we get feedback
        String result = feedback.getFeedback(secretCode, guessedCode);

        // Then the feedback should be an empty string
        assertEquals("", result,
                "Feedback should be an empty string when there are no correct colors.");
    }

    @Test
    public void givenOneCorrectColorInRightPosition_whenGetFeedback_thenReturnO() {
        // Given a secret code and a guessed code with one correct color in the correct position
        List<Character> secretCode = Arrays.asList('R', 'G', 'B', 'Y');
        List<Character> guessedCode = Arrays.asList('R', 'W', 'P', 'S');

        Feedback feedback = new Feedback();

        // When we get feedback
        String result = feedback.getFeedback(secretCode, guessedCode);

        // Then the feedback should be "o"
        assertEquals("o", result,
                "Feedback should be 'o' when one color is correct in the right position.");
    }

    @Test
    public void givenOneCorrectColorInWrongPosition_whenGetFeedback_thenReturnX() {
        // Given a secret code and a guessed code with one correct color in the wrong position
        List<Character> secretCode = Arrays.asList('R', 'G', 'B', 'Y');
        List<Character> guessedCode = Arrays.asList('W', 'R', 'P', 'S');

        Feedback feedback = new Feedback();

        // When we get feedback
        String result = feedback.getFeedback(secretCode, guessedCode);

        // Then the feedback should be "x"
        assertEquals("x", result,
                "Feedback should be 'x' when one color is correct but in the wrong position.");
    }
}