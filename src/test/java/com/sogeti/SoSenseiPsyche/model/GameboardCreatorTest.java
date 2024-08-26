package com.sogeti.SoSenseiPsyche.model;

import com.sogeti.SoSenseiPsyche.record.FeedbackRecord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import java.util.Arrays;
import java.util.List;

public class GameboardCreatorTest {

    @Test
    public void givenFeedbackRecordList_whenPrintGameBoard_thenOutputShouldBeFormattedCorrectly() throws Exception {
        // Given: A list of FeedbackRecord objects
        FeedbackRecord record1 = new FeedbackRecord(1, "R G B Y", "ooxx");
        FeedbackRecord record2 = new FeedbackRecord(2, "W O P S", "x");
        List<FeedbackRecord> feedbackRecordList = Arrays.asList(record1, record2);

        // When: We capture the output of printGameBoard method
        String output = tapSystemOut(() -> GameboardCreator.printGameBoard(feedbackRecordList));

        // Then: The output should be correctly formatted
        String expectedOutput = """
                +----+---------+------+
                | #  | Guess   | Feed |
                +----+---------+------+
                | 1  | R G B Y | ooxx |
                +----+---------+------+
                | 2  | W O P S | x    |
                +----+---------+------+
                """;

        String[] outputLines = output.trim().split("\n");
        String[] expectedLines = expectedOutput.trim().split("\n");

        assertEquals(expectedLines.length, outputLines.length,
                "Number of lines should match.");

        for (int i = 0; i < outputLines.length; i++) {
            assertEquals(expectedLines[i].trim(), outputLines[i].trim(),
                    "Line " + (i + 1) + " should match.");
        }
    }
}