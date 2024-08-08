package com.sogeti.SoSenseiPsyche.model;


public class Game {
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 12;
    boolean isGameOver;


    public void startGame() {
        System.out.println("Welcome to Mastermind!");
        System.out.println("Available colors: ");

        for (Color color : Color.values()) {
            System.out.println(color.name() + " (" + color.getName() + ")");
        }
    }
}