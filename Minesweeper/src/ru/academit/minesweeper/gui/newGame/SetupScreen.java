package ru.academit.minesweeper.gui.newGame;

import ru.academit.minesweeper.gui.GameMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Setup screen works with fieldMaker, creating when user wants to change
 * the size of the field and/or a quantity of bombs.
 * FIELD_SIZE_MAX - any number could be set but it is not recommended to
 * allow user to choose more than 15x15 for screens sizes less than or equal to 17 inches.
 */

public class SetupScreen {
    private JPanel setupScreen;
    private int fieldSize = 9;
    private int bombNumbers = 10;
    private JSlider fieldSizeSlider;
    private JSlider bombsNumberSlider;
    private static final int FIELD_SIZE_MIN = 3;
    private static final int FIELD_SIZE_MAX = 15;
    private static final int FIELD_SIZE_INIT = 9;
    private static final int BOMBS_NUMBER_MIN = 1;
    private static final int BOMBS_NUMBER_MAX = 50;
    private static final int BOMBS_NUMBER_INIT = 10;
    private JButton next;
    private JButton back;

    public SetupScreen() {
        setupScreen = new JPanel();
        setupScreen.setLayout(new BoxLayout(setupScreen, BoxLayout.PAGE_AXIS));
        JLabel welcome = new JLabel("Welcome to the minesweeper!");
        JLabel settings = new JLabel(String.format("Initial size of the filed is %d x %d. " +
                "Initial number of bombs is %d. ", fieldSize, fieldSize, bombNumbers));
        next = new JButton("NEXT");
        back = new JButton("RETURN TO THE MAIN MENU");
        next.addActionListener(new NextButtonListener());
        back.addActionListener(new BackButtonListener());
        setupScreen.add(welcome);
        setupScreen.add(settings);
        Font welcomeFont = new Font("Times New Roman", Font.PLAIN, 20);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setFont(welcomeFont);
        settings.setFont(welcomeFont);

        try {
            BufferedImage happyBombImg = ImageIO.read
                    (new File("Minesweeper/src/ru/academit/minesweeper/resources/welcomeLabel.jpeg"));
            JLabel setupPicture = new JLabel(new ImageIcon(happyBombImg));
            setupScreen.add(setupPicture);
            setupPicture.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (IOException ignored) {
            // there's no picture if reading a file is impossible
        }

        setupScreen.add(next);
        setupScreen.add(back);

        Font buttonsFont = new Font("Arial", Font.PLAIN, 30);
        next.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        next.setFont(buttonsFont);
        back.setFont(buttonsFont);
    }

    class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = "settings";
            String text = "Would you like to change the size of the play field ?";
            int dialogResult = JOptionPane.showConfirmDialog(new JFrame(), text, title, JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.NO_OPTION) {
                setupScreen.removeAll();
                GameField gameField = new GameField(fieldSize, bombNumbers);
                setupScreen.add(gameField.getGameField());

                setupScreen.repaint();
                setupScreen.revalidate();
            } else if (dialogResult == JOptionPane.YES_OPTION) {
                setupScreen.remove(next);
                Font slidersFont = new Font("Arial", Font.BOLD, 16);
                JLabel sizeLabel = new JLabel("Choose the size of the field using the slider below ");
                sizeLabel.setFont(slidersFont);
                sizeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                fieldSizeSlider = new JSlider(JSlider.HORIZONTAL, FIELD_SIZE_MIN, FIELD_SIZE_MAX, FIELD_SIZE_INIT);
                fieldSizeSlider.addChangeListener(new FieldSliderListener());
                fieldSizeSlider.setMajorTickSpacing(1);
                fieldSizeSlider.setPaintTicks(true);
                fieldSizeSlider.setPaintLabels(true);
                setupScreen.add(sizeLabel);
                setupScreen.add(fieldSizeSlider);

                JLabel bombsLabel = new JLabel("Choose the number of bombs using the slider below");
                bombsLabel.setFont(slidersFont);
                bombsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                bombsNumberSlider = new JSlider(JSlider.HORIZONTAL, BOMBS_NUMBER_MIN, BOMBS_NUMBER_MAX, BOMBS_NUMBER_INIT);
                bombsNumberSlider.addChangeListener(new BombsSliderListener());
                bombsNumberSlider.setMajorTickSpacing(1);
                bombsNumberSlider.setPaintTicks(true);
                bombsNumberSlider.setPaintLabels(true);
                setupScreen.add(bombsLabel);
                setupScreen.add(bombsNumberSlider);

                JButton ok = new JButton("OK");
                setupScreen.add(ok);
                ok.setFont(new Font("Arial", Font.BOLD, 60));
                ok.setAlignmentX(Component.CENTER_ALIGNMENT);
                ok.addActionListener(new OkButtonListener());

                setupScreen.repaint();
                setupScreen.revalidate();
            }
        }
    }

    class FieldSliderListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            fieldSizeSlider = (JSlider) e.getSource();
            if (!fieldSizeSlider.getValueIsAdjusting()) {
                fieldSize = fieldSizeSlider.getValue();
            }
        }
    }

    class BombsSliderListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            bombsNumberSlider = (JSlider) e.getSource();
            if (!bombsNumberSlider.getValueIsAdjusting()) {
                bombNumbers = bombsNumberSlider.getValue();
            }
        }
    }

    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setupScreen.removeAll();
            GameMenu gameMenu = new GameMenu();
            setupScreen.add(gameMenu.getGameMenu());
            setupScreen.repaint();
            setupScreen.revalidate();
        }
    }

    class OkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setupScreen.removeAll();
            GameField gameField = new GameField(fieldSize, bombNumbers);
            setupScreen.add(gameField.getGameField());
            setupScreen.repaint();
            setupScreen.revalidate();
        }
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public int getBombNumbers() {
        return bombNumbers;
    }

    public JPanel getSetupScreen() {
        return setupScreen;
    }
}
