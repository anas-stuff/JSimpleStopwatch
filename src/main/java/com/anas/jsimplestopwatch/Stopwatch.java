package com.anas.jsimplestopwatch;

import com.anas.jsimplestopwatch.listeners.StopwatchChangeEvent;
import com.anas.jsimplestopwatch.listeners.StopwatchChangeListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Stopwatch implements ActionListener {
    private static Stopwatch instance;
    private final ArrayList<StopwatchChangeListener> changeListeners;
    private final Timer timer;
    private final Time time;
    private boolean running;

    private Stopwatch() {
        this.changeListeners = new ArrayList<>();
        this.timer = new Timer(10, this); // every 0.01-second call actionPerformed
        this.time = new Time();
        this.running = false;
    }

    public static Stopwatch getInstance() {
        if (instance == null) {
            instance = new Stopwatch();
        }
        return instance;
    }


    public void start() {
        timer.start();
        running = true;
        notifyChangeListeners();
    }

    public void stop() {
        timer.stop();
        time.reset();
        running = false;
        notifyChangeListeners();
    }

    public void pause() {
        timer.stop();
        running = false;
    }

    public void reset() {
        time.reset();
        notifyChangeListeners();
    }


    public ArrayList<StopwatchChangeListener> getChangeListeners() {
        return changeListeners;
    }

    public void setChangeListeners(StopwatchChangeListener changeListener) {
        changeListeners.add(changeListener);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        time.increment();
        notifyChangeListeners();
    }

    public boolean isRunning() {
        return running;
    }

    private void notifyChangeListeners() {
        for (StopwatchChangeListener changeListener : changeListeners) {
            changeListener.onChange(new StopwatchChangeEvent(time));
        }
    }
}
