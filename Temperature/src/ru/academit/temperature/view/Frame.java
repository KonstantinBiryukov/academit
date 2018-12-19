package ru.academit.temperature.view;

import ru.academit.temperature.model.IScale;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame {
    private JFrame frame;
    private Dimension screenSize;

    public Frame(ArrayList<IScale> scales) {
        frame = new JFrame("Temperature Conversion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(getScaledWidth(0.5), getScaledHeight(0.5));
        frame.setMinimumSize(new Dimension(getScaledWidth(0.45), getScaledHeight(0.45)));

        MainPanel panel = new MainPanel(scales);
        frame.add(panel.getMainPanel());
    }

    private int getScaledWidth(double scaleNumber) {
        return (int) (screenSize.width * scaleNumber);
    }

    private int getScaledHeight(double scaleNumber) {
        return (int) (screenSize.height * scaleNumber);
    }
}