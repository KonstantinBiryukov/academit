package ru.academit.temperature.view;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private JFrame frame;

    public Frame() {
        frame = new JFrame("Temperature Conversion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.5);
        int height = (int) (screenSize.height * 0.5);
        frame.setSize(width, height);

        MainPanel panel = new MainPanel();
        frame.add(panel.getPanel());
    }

    public JFrame getFrame() {
        return frame;
    }
}