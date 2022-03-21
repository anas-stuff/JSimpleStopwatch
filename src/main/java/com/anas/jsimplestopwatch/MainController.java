package com.anas.jsimplestopwatch;

import com.anas.jsimplestopwatch.gui.ButtonEvent;
import com.anas.jsimplestopwatch.gui.ButtonsListener;
import com.anas.jsimplestopwatch.gui.StopwatchFrame;
import com.anas.jsimplestopwatch.gui.settings.SettingsDialog;
import com.anas.jsimplestopwatch.listeners.StopwatchChangeEvent;
import com.anas.jsimplestopwatch.listeners.StopwatchChangeListener;

import javax.swing.*;

public class MainController implements StopwatchChangeListener, ButtonsListener {
    private final StopwatchFrame stopwatchFrame;
    public MainController() {
        stopwatchFrame = new StopwatchFrame();
        stopwatchFrame.addButtonListener(this);
        Stopwatch.getInstance().setChangeListeners(this);
    }

    @Override
    public void onChange(StopwatchChangeEvent event) {
        stopwatchFrame.updateTime(event.getTime());
    }

    @Override
    public void onPress(ButtonEvent event) {
        switch (event.getType()) {
            case START -> Stopwatch.getInstance().start();
            case STOP -> Stopwatch.getInstance().stop();
            case RESET -> Stopwatch.getInstance().reset();
            case PAUSE -> Stopwatch.getInstance().pause();
            case SETTINGS -> new SettingsDialog(stopwatchFrame).setVisible(true);
        }
    }
}
