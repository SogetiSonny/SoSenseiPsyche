package com.sogeti.SoSenseiPsyche.Swing;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackCalculator {
    public static List<Character> calculateFeedback(List<Color> secretCode, List<Color> guess) {
        List<Character> feedback = new ArrayList<>();
        List<Color> secretCopy = new ArrayList<>(secretCode);
        List<Color> guessCopy = new ArrayList<>(guess);

        // First pass: Find exact matches (correct color and position)
        for (int i = 0; i < 4; i++) {
            if (guessCopy.get(i).equals(secretCopy.get(i))) {
                feedback.add('o'); // Exact match
                secretCopy.set(i, null); // Mark this spot as used
                guessCopy.set(i, null);
            }
        }

        // Second pass: Find correct colors in wrong positions
        for (int i = 0; i < 4; i++) {
            if (guessCopy.get(i) != null && secretCopy.contains(guessCopy.get(i))) {
                feedback.add('x'); // Correct color, wrong position
                secretCopy.set(secretCopy.indexOf(guessCopy.get(i)), null); // Mark this spot as used
            }
        }

        return feedback;
    }
}
