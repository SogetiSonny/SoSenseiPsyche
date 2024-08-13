package com.sogeti.SoSenseiPsyche.model;

import java.util.ArrayList;
import java.util.List;

public class Guess {
    List<Color> guess = new ArrayList<>();

    public List<Color> getGuess() {
        return guess;
    }

    public void setGuess(List<Color> guess) {
        this.guess = guess;
    }
}