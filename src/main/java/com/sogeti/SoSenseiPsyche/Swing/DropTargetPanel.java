package com.sogeti.SoSenseiPsyche.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class DropTargetPanel extends JPanel {
    public DropTargetPanel() {
        setPreferredSize(new Dimension(40, 40)); // Size of the drop target
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add a border
        setBackground(Color.WHITE); // Default background color

        // Enable the panel to accept dragged content
        setTransferHandler(new TransferHandler("background") {
            @Override
            public boolean canImport(TransferHandler.TransferSupport support) {
                return support.isDataFlavorSupported(DataFlavor.stringFlavor);
            }

            @Override
            public boolean importData(TransferHandler.TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }

                try {
                    Transferable t = support.getTransferable();
                    String colorName = (String) t.getTransferData(DataFlavor.stringFlavor);

                    // Convert the color name to an actual Color object
                    switch (colorName) {
                        case "RED":
                            setBackground(Color.RED);
                            break;
                        case "GREEN":
                            setBackground(Color.GREEN);
                            break;
                        case "BLUE":
                            setBackground(Color.BLUE);
                            break;
                        case "YELLOW":
                            setBackground(Color.YELLOW);
                            break;
                        case "ORANGE":
                            setBackground(Color.ORANGE);
                            break;
                        case "PINK":
                            setBackground(Color.PINK);
                            break;
                        default:
                            setBackground(Color.WHITE);
                            break;
                    }
                    return true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return false;
            }
        });
    }
}
