package com.anas.jsimplestopwatch.gui.settings;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SettingsPanel extends JPanel {
    private FontEditorPane timeFont, uiFont;

    public SettingsPanel() {
        initComponents();
        super.setLayout(new MigLayout());
        addComponents();
    }

    private void initComponents() {
        timeFont = new FontEditorPane("Time Font");
        uiFont = new FontEditorPane("UI Font");
    }

    private void addComponents() {
        super.add(timeFont, "wrap");
        super.add(uiFont, "wrap");
    }

    public FontEditorPane getTimeFont() {
        return timeFont;
    }

    public FontEditorPane getUIFont() {
        return uiFont;
    }
}
