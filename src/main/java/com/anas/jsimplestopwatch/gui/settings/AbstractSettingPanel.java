package com.anas.jsimplestopwatch.gui.settings;

import javax.swing.*;

public abstract class AbstractSettingPanel extends JPanel {

    public AbstractSettingPanel(String title) {
        setBorder(BorderFactory.createTitledBorder(title));
        initComponents();
        initLayout();
        addComponents();
    }

    protected abstract void initComponents();;

    protected void initLayout() {
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    protected abstract void addComponents();
}
