package com.anas.jsimplestopwatch.settings;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;

public class Settings implements Serializable {
    private Font timerFont, uiFont;
    private Color timerFontColor, uiFontColor;
    private Color timerBackgroundColor, uiBackgroundColor;

    private static Settings instance = null;

    @Serial
    private static final long serialVersionUID = 1L;

    private Settings() {
        timerFont = new Font(Font.SERIF, Font.PLAIN, 65);
        uiFont = new Font(Font.SERIF, Font.PLAIN, 35);
        timerFontColor = Color.BLACK;
        uiFontColor = Color.BLACK;
        timerBackgroundColor = Color.WHITE;
        uiBackgroundColor = Color.WHITE;
    }

    protected static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public Font getTimerFont() {
        return timerFont;
    }

    public void setTimerFont(Font timerFont) {
        this.timerFont = timerFont;
    }

    public Font getUIFont() {
        return uiFont;
    }

    public void setUIFont(Font uiFont) {
        this.uiFont = uiFont;
    }

    public Color getTimerFontColor() {
        return timerFontColor;
    }

    public void setTimerFontColor(Color timerFontColor) {
        this.timerFontColor = timerFontColor;
    }

    public Color getUIFontColor() {
        return uiFontColor;
    }

    public void setUIFontColor(Color uiFontColor) {
        this.uiFontColor = uiFontColor;
    }

    public Color getTimerBackgroundColor() {
        return timerBackgroundColor;
    }

    public void setTimerBackgroundColor(Color timerBackgroundColor) {
        this.timerBackgroundColor = timerBackgroundColor;
    }

    public Color getUIBackgroundColor() {
        return uiBackgroundColor;
    }

    public void setUIBackgroundColor(Color uiBackgroundColor) {
        this.uiBackgroundColor = uiBackgroundColor;
    }
}
