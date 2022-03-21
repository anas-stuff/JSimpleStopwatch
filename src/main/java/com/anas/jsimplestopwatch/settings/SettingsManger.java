package com.anas.jsimplestopwatch.settings;

import java.io.*;
import java.util.ArrayList;

public class SettingsManger {
    private final Settings settings;
    private final String settingPath;
    private final ArrayList<SettingsChangeListener> listeners;
    private static SettingsManger instance;

    private SettingsManger() {
        settingPath = "./.cache/settings.ser";
        listeners = new ArrayList<>();
        settings = loadSettings();
    }

    public static SettingsManger getInstance() {
        if (instance == null) {
            instance = new SettingsManger();
        }
        return instance;
    }

    private Settings loadSettings() {
        if (new File(settingPath).exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(settingPath);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Settings settings = (Settings) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                return settings;
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        return Settings.getInstance();
    }

    public void saveSettings() {
        try {
            File file = new File(settingPath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(settingPath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(settings);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Settings getSettings() {
        return settings;
    }


    public void save() {
        notifyListeners();
        saveSettings();
    }

    public void addListener(SettingsChangeListener listener) {
        if (!listeners.contains(listener))
             listeners.add(listener);
    }

    public void removeListener(SettingsChangeListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).onSettingsChanged(settings);
        }
    }
}
