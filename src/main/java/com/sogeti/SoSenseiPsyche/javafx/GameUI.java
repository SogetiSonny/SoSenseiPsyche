package com.sogeti.SoSenseiPsyche.javafx;

import com.sogeti.SoSenseiPsyche.model.Game;
import com.sogeti.SoSenseiPsyche.record.FeedbackRecord;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;

public class GameUI {
    private Game game;
    private Label attemptsLabel;
    private GameBoard gameBoard;
    private VBox root;

    public GameUI(Label attemptsLabel, VBox root) {
        this.attemptsLabel = attemptsLabel;
        this.root = root;
        this.game = new Game();
        this.gameBoard = new GameBoard();

        GridPane gameBoardPane = gameBoard.getGridPane();
        gameBoardPane.setStyle("-fx-padding: 20; -fx-background-color: #f0f0f0; -fx-border-color: #000; -fx-border-radius: 10; -fx-background-radius: 10;");
        gameBoardPane.setAlignment(Pos.CENTER);

        VBox.setVgrow(gameBoardPane, Priority.ALWAYS);

        root.getChildren().add(gameBoardPane);

        HBox pinPane = createPinPane();
        pinPane.setAlignment(Pos.CENTER);
        pinPane.setPadding(new Insets(10));
        root.getChildren().add(pinPane);
    }

    private HBox createPinPane() {
        HBox pinPane = new HBox(10);
        String[] colors = {"RED", "GREEN", "BLUE", "YELLOW", "ORANGE", "PURPLE", "WHITE"};
        for (String color : colors) {
            Pin pin = new Pin(Color.valueOf(color));
            pinPane.getChildren().add(pin);
        }
        return pinPane;
    }

    public void startGame() {
        game.startGame();
        updateUI();
    }

    public void processGuess() {
        if (!gameBoard.isRowComplete()) { // Controlla se la riga è completa
            return; // Non genera feedback finché la riga non è completa
        }

        game.processGuess();
        displayFeedback();
        gameBoard.nextRow();
        updateUI();
    }

    private void displayFeedback() {
        List<FeedbackRecord> feedback = game.getFeedbackList();
        int row = game.getAttempt() - 2;
        for (int i = 0; i < feedback.size(); i++) {
            Color color = feedback.get(i).isCorrect() ? Color.BLACK : Color.WHITE;
            gameBoard.addFeedbackPin(row, i, color);
        }
    }

    private void updateUI() {
        attemptsLabel.setText("Attempts remaining: " + game.getAttemptsRemaining());
    }
}
