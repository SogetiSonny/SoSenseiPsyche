package com.sogeti.SoSenseiPsyche.Swing;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ColorTransferHandler extends TransferHandler {
    private final String colorName;

    public ColorTransferHandler(String colorName) {
        this.colorName = colorName;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        // Transfer the color name as a string
        return new StringSelection(colorName);
    }

    @Override
    public int getSourceActions(JComponent c) {
        return TransferHandler.COPY;
    }
}
