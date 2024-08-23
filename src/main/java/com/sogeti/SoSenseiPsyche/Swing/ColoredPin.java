package com.sogeti.SoSenseiPsyche.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ColoredPin extends JLabel {
    private Color pinColor;

    public ColoredPin(Color color) {
        this.pinColor = color;
        setOpaque(true);
        setBackground(color);
        setPreferredSize(new Dimension(40, 40)); // Set the size of the pin
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add a border

        // Set the TransferHandler to handle dragging
        setTransferHandler(new TransferHandler("text") {
            @Override
            protected Transferable createTransferable(JComponent c) {
                // Transfer the color name as a string
                return new StringSelection(getColorName());
            }

            @Override
            public int getSourceActions(JComponent c) {
                return TransferHandler.COPY;
            }
        });

        // Enable dragging by setting a mouse listener
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JComponent comp = (JComponent) evt.getSource();
                TransferHandler handler = comp.getTransferHandler();

                // Trigger drag without custom drag image
                handler.exportAsDrag(comp, evt, TransferHandler.COPY);
            }
        });
    }

    public String getColorName() {
        // Return the color name as a string for easy transfer
        if (pinColor.equals(Color.RED)) return "RED";
        if (pinColor.equals(Color.GREEN)) return "GREEN";
        if (pinColor.equals(Color.BLUE)) return "BLUE";
        if (pinColor.equals(Color.YELLOW)) return "YELLOW";
        if (pinColor.equals(Color.ORANGE)) return "ORANGE";
        if (pinColor.equals(Color.PINK)) return "PINK";
        return "UNKNOWN";
    }
}
