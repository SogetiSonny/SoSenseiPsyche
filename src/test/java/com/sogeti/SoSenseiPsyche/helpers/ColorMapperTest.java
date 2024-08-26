package com.sogeti.SoSenseiPsyche.helpers;


import com.sogeti.SoSenseiPsyche.model.Color;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ColorMapperTest {

    @Test
    public void givenColorMapIsCreated_whenMapIsPopulated_thenItShouldContainAllPredefinedColorsAndCorrectMappings() {
        // Given: The ColorMapper class is used to create a color map
        Map<Character, String> colorMap = ColorMapper.setColorMap();

        // Then: The map should contain all color entries
        assertEquals(Color.values().length, colorMap.size());

        // And: The map should correctly map 'R' to 'RED' and return 'RED' for key 'R'
        assertTrue(colorMap.containsKey('R'));
        assertEquals("RED", colorMap.get('R'));

        // And: The map should correctly map 'G' to 'GREEN' and return 'GREEN' for key 'G'
        assertTrue(colorMap.containsKey('G'));
        assertEquals("GREEN", colorMap.get('G'));
    }

    @Test
    public void givenColorMap_whenColorMappingIsRequestedAsString_thenItShouldReturnCorrectMappings() {
        // Given: The ColorMapper class has a color map initialized
        // When: The color mapping is requested as a string
        String colorMapping = ColorMapper.getColorMapping();

        // Then: The mapping should contain 'R = RED'
        assertTrue(colorMapping.contains("R = RED"));

        // And: The mapping should contain 'G = GREEN'
        assertTrue(colorMapping.contains("G = GREEN"));
    }

    @Test
    public void givenColorNameOrFirstLetter_whenCheckingIfColorExistsInMap_thenItShouldReturnTrueForValidColorsAndFalseForInvalidColors() {
        // Given: A color name or its first letter
        // When: Checking if the color exists in the color map

        // Then: The method should return true for valid colors
        assertTrue(ColorMapper.doesColorExist("RED"),"RED should exist in the color map");
        assertTrue(ColorMapper.doesColorExist("R"),"R should exist in the color map");

        // And: The method should return false for invalid colors
        assertFalse(ColorMapper.doesColorExist("VIOLET"),"VIOLET should not exist in the color map");
        assertFalse(ColorMapper.doesColorExist("V"),"V should not exist in the color map");
    }
}
