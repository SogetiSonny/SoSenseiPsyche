package com.sogeti.SoSenseiPsyche.model;

import com.sogeti.SoSenseiPsyche.record.FeedbackRecord;

import java.util.List;

public class GameboardCreator {
    public static void printGameBoard(List<FeedbackRecord> feedbackRecordList) {
        for (FeedbackRecord feedbackRecord : feedbackRecordList) {
            System.out.println("| " + String.format("%-2s", feedbackRecord.attempt()) + " | "
                    + String.format("%-11s", feedbackRecord.guess().replace(",", "")) + " | "
                    + String.format("%-4s", feedbackRecord.feedback()) + " | ");
        }
    }
}
