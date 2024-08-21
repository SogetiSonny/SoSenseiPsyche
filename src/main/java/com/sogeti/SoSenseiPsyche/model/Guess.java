package com.sogeti.SoSenseiPsyche.model;

import java.util.ArrayList;
import java.util.List;

public class Guess {
    List<Color> guess = new ArrayList<>();

    public List<Color> getGuess() {
        return guess;
    }

    public void setGuess(List<Color> guess) {
        if (guess == null || guess.size() != Game.CODE_LENGTH) {
            throw new IllegalArgumentException("Guess must contain exactly " + Game.CODE_LENGTH + " colors.");
        }
        this.guess = guess;
    }



}