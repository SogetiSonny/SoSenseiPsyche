package com.sogeti.SoSenseiPsyche.model;


import java.util.Scanner;

public class Game {
    public static final int CODE_LENGTH = 4;
    boolean isGameOver;

// for testing purpose

    public void startGame() {
        System.out.println("Welcome to Mastermind!");
        System.out.println("Available colors: ");

        for (Color color : Color.values()) {
            System.out.println(color.name() + " (" + color.name().charAt(0) + ")");
        }

        Guess.getUserGuess(new Scanner(System.in));
    }
}