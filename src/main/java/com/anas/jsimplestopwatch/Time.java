package com.anas.jsimplestopwatch;

public class Time {
    private int hour;
    private int minute;
    private int second;
    private int millisecond;

    public Time() {
        setHour(0);
        setMinute(0);
        setSecond(0);
        setMillisecond(0);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(int millisecond) {
        this.millisecond = millisecond;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public void increment() {
        this.setMillisecond(this.getMillisecond() + 1);
        if (this.getMillisecond() == 100) {
            this.setMillisecond(0);
            this.setSecond(this.getSecond() + 1);
            if (this.getSecond() == 60) {
                this.setSecond(0);
                this.setMinute(this.getMinute() + 1);
                if (this.getMinute() == 60) {
                    this.setMinute(0);
                    this.setHour(this.getHour() + 1);
                }
            }
        }
    }

    public void reset() {
        setHour(0);
        setMinute(0);
        setSecond(0);
        setMillisecond(0);
    }
}
