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