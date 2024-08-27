package com.sogeti.SoSenseiPsyche.javafx;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.effect.DropShadow;

public class GameBoard {
    private GridPane gridPane;
    private int currentRow;

    public GameBoard() {
        gridPane = new GridPane();
        currentRow = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 4; col++) {
                Circle slot = createSlot(10, Color.LIGHTGRAY);
                gridPane.add(slot, col, row);
            }
            for (int col = 4; col < 8; col++) {
                Circle feedbackSlot = createSlot(5, Color.LIGHTGRAY);
                gridPane.add(feedbackSlot, col, row);
            }
        }
    }

    private Circle createSlot(int radius, Color color) {
        Circle slot = new Circle(radius, color);
        slot.setEffect(new DropShadow(5, Color.GRAY));
        return slot;
    }

    public boolean isRowComplete() {
        // Verifica se tutti e 4 i pin della riga corrente sono stati posizionati
        for (int col = 0; col < 4; col++) {
            Circle slot = (Circle) gridPane.getChildren().get(currentRow * 8 + col);
            if (slot.getFill() == Color.LIGHTGRAY) { // Se il colore è ancora grigio, il pin non è stato posizionato
                return false;
            }
        }
        return true;
    }

    public void addFeedbackPin(int row, int col, Color color) {
        Circle feedbackPin = createSlot(5, color);
        gridPane.add(feedbackPin, col + 4, row);
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void nextRow() {
        currentRow++;
    }
}
