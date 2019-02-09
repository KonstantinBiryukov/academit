package ru.academit.minesweeper.gui.newGame;

import ru.academit.minesweeper.gui.GameMenu;
import ru.academit.minesweeper.gui.IGameActions;
import ru.academit.minesweeper.model.FieldMaker;
import ru.academit.minesweeper.model.HiddenFieldMaker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Flood fill algorithm to open the adjacent cells: https://en.wikipedia.org/wiki/Flood_fill
public class GameField implements IGameActions {
    private JPanel gameFiled;
    private FieldMaker field;
    private HashMap<JButton, int[]> cells;
    // private HashMap<JButton, Boolean> currentButton;
    private int[] currentCoordinates;
    private HiddenFieldMaker hiddenField;
    private int[][] hiddenCells;
    private JButton currentButton;
    private int x;
    private int y;
    private boolean isFirstClickMade = false;
    private boolean isGameOver = false;
    private int fieldSize;
    private int bombs;
    private int cellsLength;
    private int notPressedButtons;
    private JLabel clock;
    private Timer timer;
    public final static int ONE_SECOND = 1000;
    private int currentScores = 0;
    private int finalScores = 0;
    private String playerName;
    private int flags;
    private boolean isFlagUp = false;

    public GameField(int fieldSize, int bombs) {
        this.fieldSize = fieldSize;
        this.bombs = bombs;
        flags = bombs;
        notPressedButtons = fieldSize * fieldSize;
        init();
        userInterfaceLineMake();
        createField();
    }

    public GameField() {
    }

    private void init() {
        field = new FieldMaker(fieldSize);
        cellsLength = field.getCells().length;
        cells = new HashMap<>();
        hiddenField = new HiddenFieldMaker(fieldSize, bombs);
        gameFiled = new JPanel(new GridLayout(cellsLength + 1, cellsLength)); //+1 for user interface
    }

    private void userInterfaceLineMake() {
        // bombs_number, flags_quantity, timer, restart button.
        JLabel bombsTitle = new JLabel("Bombs:");
        String bombsNumberString = String.valueOf(bombs);
        JLabel bombsNumber = new JLabel(bombsNumberString);
        JLabel flagsTitle = new JLabel("Flags");
        String flagsNumberString = String.valueOf(flags);
        JLabel flagsNumber = new JLabel(flagsNumberString);

        JLabel timerTitle = new JLabel("Time");
        clock = new JLabel("0");
        JLabel bestScoresTitle = new JLabel("BestScores");
        JLabel bestScores = new JLabel();
        JButton restartButton = new JButton("RESTART");

        gameFiled.add(bombsTitle);
        gameFiled.add(bombsNumber);

        gameFiled.add(flagsTitle);
        gameFiled.add(flagsNumber);

        gameFiled.add(timerTitle);
        gameFiled.add(clock);
        timer = new Timer(ONE_SECOND, e -> clock.setText((Integer.parseInt(clock.getText()) + 1) + ""));

        gameFiled.add(bestScoresTitle);
        gameFiled.add(bestScores);

        gameFiled.add(restartButton);
    }

    private void createField() {
        // assign picture and action_listener to each button in the field;
        for (int i = 0; i < cellsLength; i++) {
            for (int j = 0; j < cellsLength; j++) {
                currentCoordinates = new int[]{i, j};
                //cellButton = new CellButton(new JButton(), isFlagUp);
                currentButton = new JButton();
                cells.put(currentButton, currentCoordinates);
                int newCellsLength = cellsLength * 3;
                currentButton.setPreferredSize(new Dimension(newCellsLength, newCellsLength));

                try {
                    BufferedImage cellImg = ImageIO.read
                            (new File("/Users/konstantinbiriukov/IdeaProjects/academit/Minesweeper/src/" +
                                    "ru/academit/minesweeper/resources/square.png"));
                    currentButton.setIcon(new ImageIcon(cellImg));
                } catch (IOException e) {
                    currentButton.setText("[ ]"); // if the picture doesn't appear
                }
                currentButton.addActionListener(new CellListener());
                currentButton.addMouseListener(new FlagListener());
                gameFiled.add(currentButton);
            }
        }
    }

    /**
     * This is a separate function since we don't want to trigger a bomb at the first click,
     * so we set our bombs and neighbors only when the first click is initiated.
     *
     * @param x defines x-coordinate to trace a current cell;
     * @param y defines y-coordinate to trace a current cell;
     */
    @Override
    public void firstClick(int x, int y) {
        hiddenCells = hiddenField.getHiddenCells();
        hiddenField.setBombs(x, y);
        hiddenField.setNeighborhood();
        timer.start();
        currentScores++;
        openCells(x, y);
    }

    @Override
    public void click(int x, int y) {

    }

    @Override
    public void openCells(int x, int y) {
        if (hiddenCells[x][y] > 8 && currentButton.getIcon() != null) { // a cell has no neighbours, empty space.
            currentButton.setIcon(null);
            notPressedButtons--;
            openNeighborEmptyCells(x, y);
        } else if (hiddenCells[x][y] > 0 && hiddenCells[x][y] <= 8 && currentButton.getIcon() != null) {
            currentButton.setIcon(null);
            notPressedButtons--;
            String adjacentBombsNumber = Integer.toString(hiddenCells[x][y]);
            currentButton.setFont(new Font("Arial", Font.PLAIN, 40));
            currentButton.setText(adjacentBombsNumber);
        } else if (hiddenCells[x][y] == 0) {
            addPicture(currentButton, "/Users/konstantinbiriukov/IdeaProjects/academit/Minesweeper" +
                    "/src/ru/academit/minesweeper/resources/bomb_pic.jpeg", "BOMB");
            endGame("GAME OVER", "YOU LOST",
                    "/Users/konstantinbiriukov/IdeaProjects/academit/Minesweeper/src/ru/academit/minesweeper/resources/lose.jpg");
        }
    }

    @Override
    public void openNeighborEmptyCells(int x, int y) {
        checkEmptyNeighbors(x, y);
        checkEmptyNeighbors(x - 1, y - 1);
        checkEmptyNeighbors(x, y - 1);
        checkEmptyNeighbors(x + 1, y - 1);
        checkEmptyNeighbors(x - 1, y);
        checkEmptyNeighbors(x + 1, y);
        checkEmptyNeighbors(x - 1, y + 1);
        checkEmptyNeighbors(x, y + 1);
        checkEmptyNeighbors(x + 1, y + 1);
    }

    @Override  // the basis of this method is a flood-fill-algorithm, but with some extra logic.
    public void checkEmptyNeighbors(int x, int y) {
        if (x >= 0 && y >= 0 && y < fieldSize && x < fieldSize) {
            if (hiddenCells[x][y] != 0) {
                for (JButton button : cells.keySet()) {
                    if (Arrays.equals(cells.get(button), new int[]{x, y})) {
                        currentButton = button;
                        if (hiddenCells[x][y] > 8 && currentButton.getIcon() != null) {
                            currentButton.setIcon(null);
                            notPressedButtons--;
                            checkEmptyNeighbors(x - 1, y - 1);
                            checkEmptyNeighbors(x, y - 1);
                            checkEmptyNeighbors(x + 1, y - 1);
                            checkEmptyNeighbors(x - 1, y);
                            checkEmptyNeighbors(x + 1, y);
                            checkEmptyNeighbors(x - 1, y + 1);
                            checkEmptyNeighbors(x, y + 1);
                            checkEmptyNeighbors(x + 1, y + 1);
                        } else if (hiddenCells[x][y] > 0 && hiddenCells[x][y] <= 8 && currentButton.getIcon() != null) {
                            currentButton.setIcon(null);
                            notPressedButtons--;
                            String adjacentBombsNumber = Integer.toString(hiddenCells[x][y]);
                            currentButton.setFont(new Font("Arial", Font.PLAIN, 40));
                            currentButton.setText(adjacentBombsNumber);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void endGame() {

    }

    private void restartRequest() {
        gameFiled.removeAll();
        SetupScreen setupScreen = new SetupScreen(); // to call chosen preceding settings
        GameField gameField = new GameField(setupScreen.getFieldSize(), setupScreen.getBombNumbers());
        gameFiled.add(gameField.getGameField());
        gameFiled.repaint();
        gameFiled.revalidate();
    }

    @Override
    public void openAllCells() {
        for (Map.Entry<JButton, int[]> cells : cells.entrySet()) {
            int[] currentCoordinates = cells.getValue();
            int currentX = currentCoordinates[0];
            int currentY = currentCoordinates[1];
            if (hiddenCells[currentX][currentY] > 8) {
                cells.getKey().setIcon(null);
            } else if (hiddenCells[currentX][currentY] > 0 && hiddenCells[currentX][currentY] <= 8) {
                cells.getKey().setIcon(null);
                String adjacentBombsNumber = Integer.toString(hiddenCells[currentX][currentY]);
                cells.getKey().setFont(new Font("Arial", Font.PLAIN, 40));
                cells.getKey().setText(adjacentBombsNumber);
            } else if (hiddenCells[x][y] == 0) {
                addPicture(cells.getKey(), "/Users/konstantinbiriukov/IdeaProjects/" +
                        "academit/Minesweeper/src/ru/academit/minesweeper/resources/bomb_pic.jpeg", "BOMB");
            }
        }
    }

    public class FlagListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            currentButton = (JButton) e.getSource();
            int[] currentCoordinates = cells.get(currentButton);
            x = currentCoordinates[0];
            y = currentCoordinates[1];

            if (SwingUtilities.isRightMouseButton(e)) {
                if (currentButton.getIcon() != null) {
                    addPicture(currentButton, "/Users/konstantinbiriukov/IdeaProjects/academit/Minesweeper/src/" +
                            "ru/academit/minesweeper/resources/flag.jpeg", "F");
                    flags--;
                } else if (currentButton.getIcon() == null) {
                    flags++;
                }
            }
        }
    }

    public class CellListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            currentButton = (JButton) event.getSource();
            int[] currentCoordinates = cells.get(currentButton);
            x = currentCoordinates[0];
            y = currentCoordinates[1];
            if (!isFirstClickMade) { // unique event for the first mouse click
                firstClick(x, y);
                isFirstClickMade = true;
            }

            openCells(x, y);

            if (bombs == notPressedButtons) {
                timer.stop();
                scoresDialog();
                endGame("YOU WON!", "Congratulations, " + playerName + "! Your scores: " + finalScores,
                        "/Users/konstantinbiriukov/IdeaProjects/academit/Minesweeper/src/ru/academit/minesweeper/resources/win.png");

            }
        }
    }

    private int makeScoresCount() {
        // bonus for bombs_quantity
        currentScores *= (bombs / 5);
        if (bombs >= 5) {
            currentScores += bombs * 10;
        } else {
            currentScores -= (80 / bombs);
        }

        // time_bonus
        int currentTime = Integer.parseInt(clock.getText());
        if (currentTime < 100) {
            return currentScores += (100 - currentTime);
        }
        if (currentTime > 100) {
            return currentScores -= (currentTime - 100);
        }
        return currentScores;
    }

    private void scoresDialog() {
        finalScores = makeScoresCount();
        playerName = JOptionPane.showInputDialog(null,
                "Your scores:  " + finalScores + System.lineSeparator() +
                        "Type your name", "YOU WON!", JOptionPane.PLAIN_MESSAGE);
        saveScores();
    }

    private void saveScores() {
        try (FileWriter scoreWriter = new FileWriter("/Users/konstantinbiriukov/IdeaProjects/academit" +
                "/Minesweeper/src/ru/academit/minesweeper/resources/scores.txt", true)) {
            if (playerName.contains(":")) {
                playerName = playerName.replace(":", "-");
            }
            scoreWriter.write(playerName + ": " + finalScores + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //@Override
    public void endGame(String title, String text, String imageLink) {
        isGameOver = true;
        openAllCells();

        String textMessage = text + System.lineSeparator() +
                "START AGAIN or RETURN BACK TO THE MAIN MENU ";
        String[] endOptions = new String[]{"RESTART", "MAIN MENU"};
        ImageIcon lostGameIcon = new ImageIcon(imageLink);
        try {
            BufferedImage cellImg = ImageIO.read(new File(imageLink));
            Dimension buttonDimension = currentButton.getSize();
            double buttonHeight = buttonDimension.getHeight();
            double buttonWidth = buttonDimension.getWidth() * 0.75;
            lostGameIcon = new ImageIcon(cellImg.getScaledInstance((int) buttonWidth, (int) buttonHeight, Image.SCALE_DEFAULT));
        } catch (IOException ignored) {
        }

        int endGameDialog = JOptionPane.showOptionDialog(null, textMessage, title, JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, lostGameIcon, endOptions, endOptions[1]);
        if (endGameDialog == 1) { // back to the main menu
            gameFiled.removeAll();
            GameMenu gameMenu = new GameMenu();
            gameFiled.add(gameMenu.getGameMenu());
            gameFiled.repaint();
            gameFiled.revalidate();
        } else {
            restartRequest();
        }
    }

    public JPanel getGameField() {
        return gameFiled;
    }


    private void addPicture(JButton button, String mainLink, String textReplacement) {
        try {
            BufferedImage cellImg = ImageIO.read(new File(mainLink));
            Dimension buttonDimension = currentButton.getSize();
            double buttonHeight = buttonDimension.getHeight() * 0.75;
            double buttonWidth = buttonDimension.getWidth() * 0.55;
            button.setIcon(new ImageIcon(cellImg.getScaledInstance((int) buttonWidth, (int) buttonHeight, Image.SCALE_DEFAULT)));
        } catch (IOException e) {
            button.setText(textReplacement); // if the picture is not read - "Plan B"
        }
    }
}