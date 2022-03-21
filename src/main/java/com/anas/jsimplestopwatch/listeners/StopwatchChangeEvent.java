package com.anas.jsimplestopwatch.listeners;

import com.anas.jsimplestopwatch.Time;

public record StopwatchChangeEvent(Time currentTime) {

    public int getHours() {
        return currentTime.getHour();
    }

    public int getMinutes() {
        return currentTime.getMinute();
    }

    public int getSeconds() {
        return currentTime.getSecond();
    }

    public Time getTime() {
        return currentTime;
    }
}
