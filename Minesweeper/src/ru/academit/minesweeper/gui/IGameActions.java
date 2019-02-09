package ru.academit.minesweeper.gui;

/**
 * Interface is intended for main game logic actions' implementation.
 */

public interface IGameActions {

    void firstClick(int x, int y);

    void click(int x, int y);

    void openCells(int x, int y);

    void openNeighborEmptyCells(int x, int y);

    void checkEmptyNeighbors(int x, int y);

    void endGame();

    void openAllCells();
}
