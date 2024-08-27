package com.sogeti.SoSenseiPsyche.javafx;

import javafx.animation.ScaleTransition;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Pin extends Circle {
    private Color color;

    public Pin(Color color) {
        super(10, color);
        this.color = color;
        initializeDragAndDrop();
        playSpawnAnimation(); // Animazione di crescita quando il pin appare
    }

    private void initializeDragAndDrop() {
        setOnDragDetected(event -> {
            // Ingrandisci il peg originale (simulando il sollevamento)
            ScaleTransition liftAnimation = new ScaleTransition(Duration.millis(200), this);
            liftAnimation.setToX(1.5);
            liftAnimation.setToY(1.5);
            liftAnimation.play();

            Dragboard db = startDragAndDrop(TransferMode.MOVE);

            // Genera un'immagine del peg da mostrare durante il drag
            SnapshotParameters snapshotParameters = new SnapshotParameters();
            snapshotParameters.setFill(Color.TRANSPARENT);
            Image snapshot = this.snapshot(snapshotParameters, null);

            // Aggiungi l'immagine al Dragboard
            db.setDragView(snapshot, snapshot.getWidth() / 2, snapshot.getHeight() / 2);

            ClipboardContent content = new ClipboardContent();
            content.putString(color.toString());
            db.setContent(content);

            event.consume();
        });

        setOnDragDone(event -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                replacePin();
            }

            // Riporta il peg originale alla dimensione normale (simulando la caduta)
            ScaleTransition dropAnimation = new ScaleTransition(Duration.millis(200), this);
            dropAnimation.setToX(1.0);
            dropAnimation.setToY(1.0);
            dropAnimation.play();

            event.consume();
        });
    }

    private void replacePin() {
        Pin newPin = new Pin(color);
        HBox parent = (HBox) getParent();
        int index = parent.getChildren().indexOf(this);
        parent.getChildren().set(index, newPin);
    }

    private void playSpawnAnimation() {
        ScaleTransition st = new ScaleTransition(Duration.millis(300), this);
        st.setFromX(0.1);
        st.setFromY(0.1);
        st.setToX(1.0);
        st.setToY(1.0);
        st.play();
    }

    public Color getColor() {
        return color;
    }
}
