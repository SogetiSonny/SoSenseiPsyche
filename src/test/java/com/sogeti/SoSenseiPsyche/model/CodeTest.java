package com.sogeti.SoSenseiPsyche.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CodeTest {

    @Test
    public void givenCodeGenerator_whenGeneratingCode_thenItShouldHaveCorrectLength() {
        // Given: We have a Code generator
        Code code = new Code();

        // When: We generate a secret code
        List<Character> generatedCode = code.generateCode();

        // Then: The code should have the correct length of 4 characters
        assertEquals(Game.CODE_LENGTH, generatedCode.size());
    }


    @Test
    public void testGeneratingCode_ShouldCreateCodeWithCorrectLengthAndValidColors() {
        // Given I have a Code generator
        Code code = new Code();

        // When I generate a secret code
        List<Character> generatedCode = code.generateCode();

        // Then the code should have 4 characters
        assertEquals(Game.CODE_LENGTH, generatedCode.size());

        // And each character should represent the first letter of a valid color
        for (Character c : generatedCode) {
            assertTrue("RGBYWSOP".indexOf(c) >= 0);
        }
    }
}
