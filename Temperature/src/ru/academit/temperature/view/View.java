package ru.academit.temperature.view;
import javax.swing.*;

public class View {

    public View() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Frame().getFrame();
    }
}
