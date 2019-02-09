package ru.academit.minesweeper.main;

import ru.academit.minesweeper.gui.GameFrame;

import javax.swing.*;

public class GUIMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame myFrame = new GameFrame();
        });
    }
}