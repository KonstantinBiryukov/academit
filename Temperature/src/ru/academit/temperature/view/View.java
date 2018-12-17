package ru.academit.temperature.view;

import ru.academit.temperature.model.IScale;

import javax.swing.*;
import java.util.ArrayList;

public class View {
    public View(ArrayList<IScale> scales) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Frame(scales);
    }
}
