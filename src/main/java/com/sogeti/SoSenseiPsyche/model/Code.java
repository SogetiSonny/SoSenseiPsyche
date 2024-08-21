package com.sogeti.SoSenseiPsyche.model;

import java.util.ArrayList;
import java.util.List;

import static com.sogeti.SoSenseiPsyche.model.Game.CODE_LENGTH;

public class Code {

    private Color createRandomColour() {
        int max = 8;
        int randomNum = (int) (Math.random() * max);

        return Color.values()[randomNum];
    }

    public List<Character> generateCode() {
        List<Character> code = new ArrayList<>();

        for (int i = 0; i < CODE_LENGTH; i++) {
            code.add(createRandomColour().name().charAt(0));
        }
        return code;
    }
}
