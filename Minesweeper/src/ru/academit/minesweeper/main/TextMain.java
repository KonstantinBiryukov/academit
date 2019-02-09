package ru.academit.minesweeper.main;

import ru.academit.minesweeper.text.GameFieldText;

import javax.swing.*;

public class TextMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFieldText gameFieldText = new GameFieldText();
        });
    }
}
