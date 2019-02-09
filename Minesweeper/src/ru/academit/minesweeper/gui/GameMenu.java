package ru.academit.minesweeper.gui;

import ru.academit.minesweeper.gui.newGame.SetupScreen;
import ru.academit.minesweeper.text.GameFieldText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class GameMenu extends JFrame {
    private JPanel gameMenu;
    private JButton newGameButton;
    private JButton highScoresButton;
    private JButton aboutButton;
    private JButton exitButton;
    private JButton switchToTextButton;

    public GameMenu() {
        newGameButton = new JButton("New Game");
        highScoresButton = new JButton("High Scores");
        aboutButton = new JButton("About");
        exitButton = new JButton("Exit");
        switchToTextButton = new JButton("Switch from graphic to text (console) interface");

        gameMenu = new JPanel();
        gameMenu.setLayout(new BoxLayout(gameMenu, BoxLayout.Y_AXIS));
        JButton[] menuButtons = new JButton[]{newGameButton, highScoresButton, aboutButton, switchToTextButton, exitButton};
        Font buttonsFont = new Font("Arial", Font.BOLD, 40);

        for (JButton button : menuButtons) {
            gameMenu.add(button); // add each button to the main menu
            button.setFont(buttonsFont); // apply a font to each button
            button.setAlignmentX(Component.CENTER_ALIGNMENT);  //setXAlignment for each button
        }

        newGameButton.addActionListener(new NewGameButtonListener());
        highScoresButton.addActionListener(new HighScoresButtonListener());
        aboutButton.addActionListener(new AboutButtonListener());
        switchToTextButton.addActionListener(new SwitchToTextButtonListener());
        exitButton.addActionListener(e -> System.exit(0));
    }

    public JPanel getGameMenu() {
        return gameMenu;
    }

    public class NewGameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameMenu.removeAll();
            SetupScreen setupScreen = new SetupScreen();
            gameMenu.add(setupScreen.getSetupScreen());
            gameMenu.repaint();
            gameMenu.revalidate();
        }
    }

    public class HighScoresButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<HighScores> scores = new ArrayList<>(10);
            try (Scanner scanner = new Scanner(new FileInputStream("/Users/konstantinbiriukov/IdeaProjects/academit" +
                    "/Minesweeper/src/ru/academit/minesweeper/resources/scores.txt"))) {
                while (scanner.hasNextLine()) {
                    String s = scanner.nextLine();
                    String[] currentInfo = s.split(": "); // name: score;
                    String currentPlayer = currentInfo[0];
                    int currentScore = Integer.valueOf(currentInfo[1]);
                    HighScores highScores = new HighScores(currentPlayer, currentScore);
                    scores.add(highScores);
                }

                List<HighScores> sortedScores =
                        scores.stream()
                                .sorted(Comparator.comparingInt(HighScores::getPlayerScore).reversed())
                                .collect(Collectors.toList());

                String highScores = sortedScores.toString();
                String[] allScores = highScores.split(", "); // number=name, number=name,...
                StringBuilder sb = new StringBuilder();
                int counter = 0;

                sb.append("PLACE | SCORES | NAME")
                        .append(System.lineSeparator());
                for (String allScore : allScores) {
                    counter++;
                    if (counter > 10) {
                        break;
                    }
                    sb.append("   ")
                            .append(counter)
                            .append(".          ")
                            .append(allScore)
                            .append(System.lineSeparator());
                }
                String result = sb.toString()
                        .replace("[", "")
                        .replace("]", "");
                ImageIcon boardIcon = new ImageIcon("/Users/konstantinbiriukov/IdeaProjects/academit/Minesweeper/src/ru/academit/minesweeper/resources/boardIcon.png");
                JOptionPane.showMessageDialog(null, result, "scoreboard - TOP_10", 1, boardIcon);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    public class AboutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(new GameMenu(), "The game is made by Biriukov Konstantin. "
                    + System.lineSeparator() +
                    "How to play Minesweeper: https://www.wikihow.com/Play-Minesweeper");
        }
    }

    public class SwitchToTextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JLabel notification = new JLabel("Look at the console! Your text game has started!");
            notification.setForeground(Color.RED);
            gameMenu.add(notification);
            notification.setAlignmentX(Component.CENTER_ALIGNMENT);
            gameMenu.repaint();
            gameMenu.revalidate();

            class TextFrameThread implements Runnable {

                @Override
                public void run() {
                    GameFieldText gameFieldText = new GameFieldText(); // вопрос по стилю кода = выделять ли память тут ?
                }
            }

            Thread t = new Thread(new TextFrameThread());
            t.start();
            //TODO: многопоточность нужно грамотно реализовать, обеспечить синхронизированный доступ к данным
            //gameFrame.getGameFrame().setExtendedState(JFrame.ICONIFIED);
        }
    }
}