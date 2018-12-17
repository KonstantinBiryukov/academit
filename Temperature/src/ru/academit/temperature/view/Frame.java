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
        frame.setSize(setWidth(0.5), setHeight(0.5));
        frame.setMinimumSize(new Dimension(setWidth(0.45), setHeight(0.45)));

        MainPanel panel = new MainPanel(scales);
        frame.add(panel.getMainPanel());
    }

    private int setWidth(double scaleNumber) {
        return (int) (screenSize.width * scaleNumber);
    }

    private int setHeight(double scaleNumber) {
        return (int) (screenSize.height * scaleNumber);
    }
}