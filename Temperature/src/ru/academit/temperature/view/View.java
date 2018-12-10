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

// Во view надо будет просто передать список поддерживаемых шкал, на основании них построить UI.
// И там уже тогда не будет тех if'ов. Шкалы передать в конструктор View

        // from to
        //  C   C
        //  F   F
        //  K   K
        new Frame().getFrame();
    }
}
