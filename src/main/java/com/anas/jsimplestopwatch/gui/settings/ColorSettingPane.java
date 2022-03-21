package com.anas.jsimplestopwatch.gui.settings;

import com.anas.jsimplestopwatch.settings.SettingsManger;
import de.milchreis.uibooster.UiBooster;

import javax.swing.*;
import java.awt.*;

public class ColorSettingPane extends AbstractSettingPanel {
    private JLabel fontColorLabel, backgroundColorLabel;
    private JButton openFontColorPickerButton, openBackgroundColorPickerButton;
    private Color fontColor, backgroundColor;

    public ColorSettingPane(String title) {
        super(title);
        addListeners();
    }

    @Override
    protected void initComponents() {
        fontColorLabel = new JLabel("Font Color");
        backgroundColorLabel = new JLabel("Background Color");

        openFontColorPickerButton = new JButton("Choose");
        openBackgroundColorPickerButton = new JButton("Choose");
    }

    @Override
    protected void addComponents() {
        add(fontColorLabel);
        add(openFontColorPickerButton);
        add(backgroundColorLabel);
        add(openBackgroundColorPickerButton);
    }

    private void addListeners() {
        openFontColorPickerButton.addActionListener(e ->
                fontColor = JColorChooser.showDialog(this, "Choose Font Color", fontColor));

        openBackgroundColorPickerButton.addActionListener(e ->
                backgroundColor = JColorChooser.showDialog(this, "Choose Background Color", backgroundColor));
    }

    public void setEditedFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public void setEditedBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getEditedFontColor() {
        return fontColor;
    }

    public Color getEditedBackgroundColor() {
        return backgroundColor;
    }
}
