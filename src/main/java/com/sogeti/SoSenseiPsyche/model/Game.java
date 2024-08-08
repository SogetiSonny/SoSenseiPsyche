package com.sogeti.SoSenseiPsyche.model;


import java.util.Scanner;

public class Game {
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 10;
    private final String[] COLORS = {"R", "G", "B", "Y", "O", "P"};
    private final Scanner scanner = new Scanner(System.in);

    public Game() {
    }

    public void play() {
        System.out.println("Welcome to Mastermind!");
        System.out.println("Available colors: R (Red), G (Green), B (Blue), Y (Yellow), O (Orange), P (Purple), W (White), S (Silver)");

    }
}