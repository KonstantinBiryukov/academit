package ru.academit.minesweeper.gui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JFrame frame;
    private Dimension screenSize;

    public GameFrame() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(getScaledWidth(0.8), getScaledWidth(0.8));
        frame.setMinimumSize(new Dimension(getScaledWidth(0.7), getScaledHeight(0.7)));

        GameMenu gameMenu = new GameMenu();
        frame.add(gameMenu.getGameMenu());
    }

    public int getScaledWidth(double scale) {
        return (int) (screenSize.width * scale);
    }

    public int getScaledHeight(double scale) {
        return (int) (screenSize.height * scale);
    }

    public JFrame getGameFrame() {
        return frame;
    }
}
