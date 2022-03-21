package com.anas.jsimplestopwatch.gui.settings;

import javax.swing.*;
import java.awt.*;

public class FontEditorPane extends AbstractSettingPanel {
    private JLabel fontNameLabel, fontSizeLabel, fontStyleLabel;
    private JComboBox<String> fontNameComboBox, fontStyleComboBox;
    private JSpinner fontSizeSpinner;

    public FontEditorPane(String title) {
        super(title);
        setFontsComboBox();
    }

    private void setFontsComboBox() {
        fontNameComboBox.setModel(new DefaultComboBoxModel<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));

        fontStyleComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Plain", "Bold", "Italic"}));
    }

    @Override
    protected void addComponents() {
        super.add(fontNameLabel);
        super.add(fontNameComboBox);
        super.add(fontSizeLabel);
        super.add(fontSizeSpinner);
        super.add(fontStyleLabel);
        super.add(fontStyleComboBox);
    }

    @Override
    protected void initComponents() {
        fontNameLabel = new JLabel("Font Name");
        fontSizeLabel = new JLabel("Font Size");
        fontStyleLabel = new JLabel("Font Style");

        fontNameComboBox = new JComboBox<>();
        fontStyleComboBox = new JComboBox<>();
        fontSizeSpinner = new JSpinner(new SpinnerNumberModel(12, 8, 250, 1));
    }

    public String getFontName() {
        return (String) fontNameComboBox.getSelectedItem();
    }

    public int getFontSize() {
        return (int) fontSizeSpinner.getValue();
    }

    public void setEditedFont(Font font) {
        fontNameComboBox.setSelectedItem(font.getName());
        fontSizeSpinner.setValue(font.getSize());
        fontStyleComboBox.setSelectedItem(font.getStyle());
    }

    public int getFontStyle() {
        return getFontStyle(fontStyleComboBox.getSelectedIndex());
    }

    public void setFontName(String fontName) {
        fontNameComboBox.setSelectedItem(fontName);
    }

    public void setFontSize(int fontSize) {
        fontSizeSpinner.setValue(fontSize);
    }

    public void setFontStyle(int fontStyle) {
        fontStyleComboBox.setSelectedIndex(fontStyle);
    }

    public Font getEditedFont() {
        return new Font(getFontName(), getFontStyle(), getFontSize());
    }


    private int getFontStyle(int selectedIndex) {
        return switch (selectedIndex) {
            case 1 -> Font.BOLD;
            case 2 -> Font.ITALIC;
            default -> Font.PLAIN;
        };
    }
}
