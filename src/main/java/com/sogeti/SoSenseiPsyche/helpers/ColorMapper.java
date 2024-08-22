package com.sogeti.SoSenseiPsyche.helpers;

import com.sogeti.SoSenseiPsyche.model.Color;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ColorMapper {
    public static Map<Character, String> setColorMap() {
        Map<Character, String> colorMap = new LinkedHashMap<>();
        for (Color color : Color.values()) {
            colorMap.put(color.name().charAt(0), color.name());
        }
        return colorMap;
    }

    public static String getColorMapping() {
        Map<Character, String> colorMap = setColorMap();
        StringBuilder colorMapping = new StringBuilder();
        for (Map.Entry<Character, String> entry : colorMap.entrySet()) {
            colorMapping.append(entry.getKey()).append(" = ").append(entry.getValue()).append(", ");
        }

        if (colorMapping.length() > 0) {
            colorMapping.setLength(colorMapping.length() - 2);
        }

        return colorMapping.toString();
    }

    public static boolean doesColorExist(char colorKey) {
        Map<Character, String> colorMap = setColorMap();
        return colorMap.containsKey(colorKey);
    }
}
