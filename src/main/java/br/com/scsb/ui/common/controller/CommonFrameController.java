package br.com.scsb.ui.common.controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public abstract class CommonFrameController {

    protected void registerAction(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }

    public abstract void prepareAndOpenFrame();
}
