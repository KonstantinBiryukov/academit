package ru.academit.minesweeper.gui;


public class HighScores {
    private String playerName;
    private int playerScore;

    public HighScores(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public String toString() {
        return playerScore + "        " + playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
//    private int bombs;
//    private int currentScores;
//    private GameField gameField;
//    private int finalScores;
//    private String playerName;
//    private int currentTime;
//
//    public HighScores() {
//        gameField = new GameField(9, 10);
//        scoresDialog();
//    }
//
//    public String getPlayerName() {
//        return playerName;
//    }
//
//    public int getFinalScores() {
//        return finalScores;
//    }
//
//    private int makeScoresCount() {
//        bombs = gameField.getBombs();
//        currentScores = gameField.getCurrentScores();
//
//        // bonus for bombs_quantity
//        currentScores *= (bombs / 5);
//        if (bombs >= 5) {
//            currentScores += bombs * 10;
//        } else {
//            currentScores -= (80 / bombs);
//        }
//
//        // time_bonus
//       // int currentTime = Integer.parseInt(gameField.getClock().getText());
//        currentTime = gameField.currentTime;
//        if (currentTime < 100) {
//            return currentScores += (100 - currentTime);
//        }
//        if (currentTime > 100) {
//            return currentScores -= (currentTime - 100);
//        }
//        return currentScores;
//    }
//
//    private void scoresDialog() {
//        finalScores = makeScoresCount();
//        playerName = JOptionPane.showInputDialog(null,
//                "Your scores:  " + finalScores + System.lineSeparator() +
//                        "Type your name", "YOU WON!", JOptionPane.PLAIN_MESSAGE);
//    }
//
//}
