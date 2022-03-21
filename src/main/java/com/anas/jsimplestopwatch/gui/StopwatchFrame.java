package com.anas.jsimplestopwatch.gui;

import com.anas.jsimplestopwatch.Time;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StopwatchFrame extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, pauseButton, stopButton, resetButton;
    private JLabel settingsLabel;
    private final ArrayList<ButtonsListener> buttonsListeners;

    public StopwatchFrame() {
        buttonsListeners = new ArrayList<>();
        initializeComponents();
        setupFrame();
        setupComponents();
        addTheComponentsToTheFrame();
        setVisible(true);
    }

    private void initializeComponents() {
        timeLabel = new JLabel("00:00.00");
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        settingsLabel = new JLabel("⚙️");
    }

    private void setupFrame() {
        super.setTitle("Stopwatch");
        super.setLayout(new MigLayout());
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setPreferredSize(new Dimension(560, 560));
    }

    private void setupComponents() {
        timeLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 65));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);

        Font buttonFont = new Font(Font.SERIF, Font.PLAIN, 35);
        startButton.setFont(buttonFont);
        pauseButton.setFont(buttonFont);
        stopButton.setFont(buttonFont);
        resetButton.setFont(buttonFont);
        settingsLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 35));

        setButtonsListeners();
    }

    private void setButtonsListeners() {
        startButton.addActionListener(e -> notifyButtonListeners(new ButtonEvent(ButtonEvent.ButtonType.START)));
        pauseButton.addActionListener(e -> notifyButtonListeners(new ButtonEvent(ButtonEvent.ButtonType.PAUSE)));
        stopButton.addActionListener(e -> notifyButtonListeners(new ButtonEvent(ButtonEvent.ButtonType.STOP)));
        resetButton.addActionListener(e -> notifyButtonListeners(new ButtonEvent(ButtonEvent.ButtonType.RESET)));
    }

    private void addTheComponentsToTheFrame() {
        super.add(timeLabel, "wrap");
        super.add(startButton, "span, grow");
        super.add(stopButton, "grow");
        super.add(resetButton, "grow, wrap");
        super.add(settingsLabel, "wrap");
    }

    public void addButtonListener(ButtonsListener buttonsListener) {
        buttonsListeners.add(buttonsListener);
    }

    public void updateTime(Time time) {
        timeLabel.setText(time.toString());
    }

    private void notifyButtonListeners(ButtonEvent buttonEvent) {
        for (ButtonsListener buttonsListener : buttonsListeners) {
            buttonsListener.onPress(buttonEvent);
        }
    }
}
