//package ru.academit.minesweeper.model;
//
//import javax.swing.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class HighScores {
//    private JPanel highScoresPanel;
//    // private int highScores = -1;
//    private String highScore = null;
//
//
//    public HighScores() {
//        highScores = new JPanel();
//        highScores.setLayout(new BoxLayout(highScores, BoxLayout.PAGE_AXIS));
//    }
//
//    public void scoreInit() throws IOException {
//        if (highScore == null) {
//            highScore = this.getHighScore();
//        }
//    }
//
//    public String getHighScore() throws IOException { // use Hashmap
//        FileReader highScores = new FileReader("hishscore.dat");
//        BufferedReader reader = new BufferedReader(highScores);
//        return reader.readLine();
//    }
//
//    public void setNewScore() {
//        highScores.add();
//    }
//
//    public JPanel getHighScores() {
//        return highScores;
//    }
//}
