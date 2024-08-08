package com.sogeti.SoSenseiPsyche.model;

public enum Color {
    RED,
    GREEN,
    BLUE,
    YELLOW,
    WHITE,
    SILVER,
    ORANGE,
    PINK;

    public static boolean isCorrectColor(char c) {
        for (Color color : Color.values()) {
            if (color.name().charAt(0) == c) {
                return true;
            }
        }
        return false;
    }
}