package com.sogeti.SoSenseiPsyche.model;

import java.util.ArrayList;
import java.util.List;

public class Code {
    List<Color> code = new ArrayList<>();

    private Color createRandomColour() {
        int max = 8;
        int randomNum = (int) (Math.random() * max);
        return switch (randomNum) {
            case 0 -> Color.BLUE;
            case 1 -> Color.ORANGE;
            case 2 -> Color.PINK;
            case 3 -> Color.GREEN;
            case 4 -> Color.RED;
            case 5 -> Color.SILVER;
            case 6 -> Color.WHITE;
            case 7 -> Color.YELLOW;
            default -> throw new IllegalStateException("Unexpected value: " + randomNum);
        };
    }

    public void generateCode() {
        for (int i = 0; i < 4; i++) {
            code.add(createRandomColour());
        }
    }

    public List<Color> getCode() {
        return code;
    }
}
