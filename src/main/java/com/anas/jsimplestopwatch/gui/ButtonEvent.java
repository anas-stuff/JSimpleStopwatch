package com.anas.jsimplestopwatch.gui;

public class ButtonEvent {
    public static enum ButtonType {
        START,
        PAUSE,
        STOP,
        RESET;
    }
    private ButtonType type;

    public ButtonEvent(ButtonType type) {
        this.type = type;
    }

    public ButtonType getType() {
        return type;
    }
}
