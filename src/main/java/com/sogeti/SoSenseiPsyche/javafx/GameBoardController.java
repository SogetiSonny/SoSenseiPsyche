package com.sogeti.SoSenseiPsyche.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameBoardController extends Application {

    private com.sogeti.SoSenseiPsyche.javafx.GameUI gameUI;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        Label welcomeLabel = new Label("Welcome to So Sensei Psyche!");
        Label attemptsLabel = new Label("Attempts remaining: 12");
        Button submitButton = new Button("Submit Guess");

        gameUI = new com.sogeti.SoSenseiPsyche.javafx.GameUI(attemptsLabel, root);

        submitButton.setOnAction(event -> {
            gameUI.processGuess();
        });

        root.getChildren().addAll(welcomeLabel, attemptsLabel, submitButton);

        Scene scene = new Scene(root, 600, 600); // Adjusted size
        primaryStage.setTitle("So Sensei Psyche");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}