package com.anas.jsimplestopwatch;

import com.anas.jsimplestopwatch.listeners.StopwatchChangeEvent;
import com.anas.jsimplestopwatch.listeners.StopwatchChangeListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {
    private static Stopwatch instance;
    private StopwatchChangeListener changeListener;
    private final Timer timer;
    private final Time time;

    private Stopwatch() {
        this.changeListener = null;
        this.timer = new Timer(1000, this); // every second call actionPerformed
        this.time = new Time();
    }

    public static Stopwatch getInstance() {
        if (instance == null) {
            instance = new Stopwatch();
        }
        return instance;
    }


    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
        time.reset();
    }

    public void pause() {
        timer.stop();
    }

    public void reset() {
        time.reset();
    }


    public StopwatchChangeListener getChangeListener() {
        return changeListener;
    }

    public void setChangeListener(StopwatchChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        time.increment();
        if (changeListener != null) {
            changeListener.onChange(new StopwatchChangeEvent(time));
        }
    }
}
