package com.sogeti.SoSenseiPsyche.model;

public enum Color {
    R("Red"),
    G("Green"),
    B("Blue"),
    Y("Yellow"),
    O("Orange"),
    P("Purple"),
    W("White"),
    S("Silver");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public static boolean isCorrectColor(char c) {
        for (Color color : Color.values()) {
            if (color.name().charAt(0) == c) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
