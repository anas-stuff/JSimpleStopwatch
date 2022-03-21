package com.anas.jsimplestopwatch.gui;

public class ButtonEvent {
    public static enum Type {
        START,
        PAUSE,
        STOP,
        RESET;
    }
    private Type type;

    public ButtonEvent(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
