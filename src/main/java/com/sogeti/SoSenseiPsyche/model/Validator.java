package com.sogeti.SoSenseiPsyche.model;

class Validator {
    public static boolean isValidColor(char c, String[] colors) {
        for (String color : colors) {
            if (color.charAt(0) == c) {
                return true;
            }
        }
        return false;
    }
}