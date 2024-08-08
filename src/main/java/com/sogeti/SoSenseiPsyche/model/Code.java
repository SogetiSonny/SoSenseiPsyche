package com.sogeti.SoSenseiPsyche.model;

import java.util.ArrayList;
import java.util.List;

public class Code {
    List<Colour> code = new ArrayList<>();

    Colour createRandomColour() {
        int max = 8;
        int randomNum = (int) (Math.random() * max);
        return switch (randomNum) {
            case 0 -> Colour.BLUE;
            case 1 -> Colour.ORANGE;
            case 2 -> Colour.PINK;
            case 3 -> Colour.GREEN;
            case 4 -> Colour.RED;
            case 5 -> Colour.SILVER;
            case 6 -> Colour.WHITE;
            case 7 -> Colour.YELLOW;
            default -> throw new IllegalStateException("Unexpected value: " + randomNum);
        };
    }

    public void generateCode() {
        for (int i = 0; i < 4; i++) {
            code.add(createRandomColour());
        }
    }

    public List<Colour> getCode() {
        return code;
    }
}
