package com.anas.jsimplestopwatch.gui.settings;

import com.anas.jsimplestopwatch.settings.Settings;
import com.anas.jsimplestopwatch.settings.SettingsManger;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    private FontEditorPane timeFont, uiFont;
    private ColorSettingPane timeColor, uiColor;

    public SettingsPanel() {
        initComponents();
        super.setLayout(new MigLayout());
        setDefaultsValues();
        addComponents();
    }

    private void initComponents() {
        timeFont = new FontEditorPane("Time Font");
        uiFont = new FontEditorPane("UI Font");

        timeColor = new ColorSettingPane("Time Color");
        uiColor = new ColorSettingPane("UI Color");
    }

    private void setDefaultsValues() {
        timeFont.setEditedFont(SettingsManger.getInstance().getSettings().getTimerFont());
        uiFont.setEditedFont(SettingsManger.getInstance().getSettings().getUIFont());

        timeColor.setEditedFontColor(SettingsManger.getInstance().getSettings().getTimerFontColor());
        timeColor.setEditedBackgroundColor(SettingsManger.getInstance().getSettings().getTimerBackgroundColor());

        uiColor.setEditedFontColor(SettingsManger.getInstance().getSettings().getUIFontColor());
        uiColor.setEditedBackgroundColor(SettingsManger.getInstance().getSettings().getUIBackgroundColor());
    }
    private void addComponents() {
        super.add(timeFont, "split 2, grow");
        super.add(uiFont, "grow");
        super.add(timeColor, "wrap");
        super.add(uiColor, "wrap");
    }

    public FontEditorPane getTimeFont() {
        return timeFont;
    }

    public FontEditorPane getUIFont() {
        return uiFont;
    }

    public void setTimeFont(Font font) {
        timeFont.setEditedFont(font);
    }

    public void setUIFont(Font font) {
        uiFont.setEditedFont(font);
    }

    public ColorSettingPane getTimeColor() {
        return timeColor;
    }

    public ColorSettingPane getUIColor() {
        return uiColor;
    }


    public void save() {
        Settings settings = SettingsManger.getInstance().getSettings();

        settings.setTimerFont(timeFont.getEditedFont());
        settings.setUIFont(uiFont.getEditedFont());

        settings.setTimerFontColor(timeColor.getEditedFontColor());
        settings.setTimerBackgroundColor(timeColor.getEditedBackgroundColor());

        settings.setUIFontColor(uiColor.getEditedFontColor());
        settings.setUIBackgroundColor(uiColor.getEditedBackgroundColor());
    }


}
