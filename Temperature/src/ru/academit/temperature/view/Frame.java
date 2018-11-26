package ru.academit.temperature.view;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private JFrame frame;
    private int width;
    private int height;

    public Frame() {
        frame = new JFrame("Temperature");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) (screenSize.width * 0.5);
        height = (int) (screenSize.height * 0.5);
        frame.setSize(width, height);

    }
}