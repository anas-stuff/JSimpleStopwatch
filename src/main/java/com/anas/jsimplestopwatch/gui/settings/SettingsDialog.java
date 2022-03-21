package com.anas.jsimplestopwatch.gui.settings;

import com.anas.jsimplestopwatch.settings.Settings;
import com.anas.jsimplestopwatch.settings.SettingsManger;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SettingsDialog extends JDialog {
    private SettingsPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public SettingsDialog(JFrame parent) {
        initializeComponents();
        setupContentPane();
        setContentPane(contentPane);
        setModal(false);
        getRootPane().setDefaultButton(buttonOK);

        addComponents();

        addListeners();

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void setupContentPane() {
        contentPane.setLayout(new MigLayout());
    }

    private void addComponents() {
        contentPane.add(buttonOK);
        contentPane.add(buttonCancel);
    }

    private void addListeners() {
        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initializeComponents() {
        contentPane = new SettingsPanel();
        buttonOK = new JButton("OK");
        buttonCancel = new JButton("Cancel");
    }

    private void onOK() {
        contentPane.save();
        SettingsManger.getInstance().save();
        exit();
    }

    private void onCancel() {
        exit();
    }

    public void exit() {
        dispose();
    }
}
