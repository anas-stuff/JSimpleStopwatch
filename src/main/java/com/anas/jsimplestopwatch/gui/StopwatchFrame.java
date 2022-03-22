package com.anas.jsimplestopwatch.gui;

import com.anas.jsimplestopwatch.Stopwatch;
import com.anas.jsimplestopwatch.Time;
import com.anas.jsimplestopwatch.gui.settings.SettingsDialog;
import com.anas.jsimplestopwatch.settings.Settings;
import com.anas.jsimplestopwatch.settings.SettingsChangeListener;
import com.anas.jsimplestopwatch.settings.SettingsManger;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class StopwatchFrame extends JFrame implements SettingsChangeListener {
    private JLabel timeLabel;
    private JPanel timePanel;
    private JButton startButton, stopButton, resetButton;
    private JLabel settingsLabel;
    private final ArrayList<ButtonsListener> buttonsListeners;

    public StopwatchFrame() {
        buttonsListeners = new ArrayList<>();
        initializeComponents();
        setupFrame();
        setupComponents();
        addTheComponentsToTheFrame();
        SettingsManger.getInstance().addListener(this);
        setVisible(true);
    }

    private void initializeComponents() {
        timeLabel = new JLabel("00:00.00");
        timePanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        settingsLabel = new JLabel("⚙️");
    }

    private void setupFrame() {
        super.setTitle("Stopwatch");
        super.setLayout(new MigLayout());
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setSize(new Dimension(560, 560));
    }

    private void setupComponents() {
        setupSettings(SettingsManger.getInstance().getSettings());
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);
        timeLabel.setOpaque(true);

        setupTimePanel();

        setButtonsListeners();
    }

    private void setupTimePanel() {
        timePanel.setLayout(new BorderLayout());
        timePanel.add(timeLabel, BorderLayout.CENTER);
    }

    private void setButtonsListeners() {
        startButton.addActionListener(e -> {
            notifyButtonListeners(
                new ButtonEvent(Stopwatch.getInstance().isRunning()?
                        ButtonEvent.Type.PAUSE : ButtonEvent.Type.START));
            if (Stopwatch.getInstance().isRunning())
                startButton.setText("Pause");
            else
                startButton.setText("Start");
        });
        stopButton.addActionListener(e -> {
            if (Stopwatch.getInstance().isRunning())
                startButton.setText("Start");
            notifyButtonListeners(new ButtonEvent(ButtonEvent.Type.STOP));
        });
        resetButton.addActionListener(e -> notifyButtonListeners(new ButtonEvent(ButtonEvent.Type.RESET)));
        addSettingsLabelListener();
    }

    private void addSettingsLabelListener() {
        settingsLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (!SettingsDialog.isOpen()) {
                    notifyButtonListeners(new ButtonEvent(ButtonEvent.Type.SETTINGS));
                }
            }
            @Override
            public void mousePressed(MouseEvent mouseEvent) { }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) { }
            @Override
            public void mouseEntered(MouseEvent mouseEvent) { }
            @Override
            public void mouseExited(MouseEvent mouseEvent) { }
        });
    }

    private void addTheComponentsToTheFrame() {
        super.add(timePanel, "grow, push, wrap");
        super.add(startButton, "split 3, grow");
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

    @Override
    public void onSettingsChanged(Settings settings) {
        setupSettings(settings);
    }

    private void setupSettings(Settings settings) {
        timeLabel.setFont(settings.getTimerFont());
        timeLabel.setForeground(settings.getTimerFontColor());
        timeLabel.setBackground(settings.getTimerBackgroundColor());

        startButton.setFont(settings.getUIFont());
        startButton.setForeground(settings.getUIFontColor());

        stopButton.setFont(settings.getUIFont());
        stopButton.setForeground(settings.getUIFontColor());

        resetButton.setFont(settings.getUIFont());
        resetButton.setForeground(settings.getUIFontColor());

        // Settings label is emoji, so it's not necessary to change its font
        settingsLabel.setFont(new Font(Font.SERIF, settings.getUIFont().getStyle(), settings.getUIFont().getSize()));
        settingsLabel.setForeground(settings.getUIFontColor());

        super.getContentPane().setBackground(settings.getUIBackgroundColor());
    }
}
