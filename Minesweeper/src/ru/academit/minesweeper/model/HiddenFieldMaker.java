package ru.academit.minesweeper.model;

/**
 * This class constructs a main field that is hidden from a player
 * but contains the game's logic. When a player open any cell
 * it inevitably leads to comparison of the chosen cell with the
 * value of the cell that is created in the hidden field.
 */

public class HiddenFieldMaker {
    private int fieldSize = 9;
    private int bombsNumber = 10;
    private int[][] hiddenCells;
    private byte[] bombs;

    public HiddenFieldMaker() {
        createHiddenField();
    }

    public HiddenFieldMaker(int fieldSize, int bombsNumber) {
        this.fieldSize = fieldSize;
        this.bombsNumber = bombsNumber;
        createHiddenField();
    }

    public void createHiddenField() {
        int count = 9; // 0-8 are reserved for bombs and neighbors
        hiddenCells = new int[fieldSize][fieldSize];
        for (int i = 0; i < hiddenCells.length; i++) {
            for (int j = 0; j < hiddenCells[i].length; j++) {
                hiddenCells[i][j] = count++;
            }
        }
    }

    private byte[] createBombs() {
        bombs = new byte[bombsNumber];
        for (int i = 0; i < bombs.length; i++) {
            bombs[i] = 0;
        }
        return bombs;
    }

    /**
     * firstX, firstY - coordinates of the cell that was clicked
     * in the first move. To set a bomb to these coordinates is
     * a prohibited action in order to avoid the end game at the first move.
     * Other bombs are set to the random coordinates and are assigned to
     * the corresponding cells.
     */
    public void setBombs(int firstX, int firstY) {
        createBombs();
        for (int i = 0; i < bombs.length; i++) {
            int randomX = (int) (Math.random() * fieldSize);
            int randomY = (int) (Math.random() * fieldSize);
            if (randomX == firstX && randomY == firstY) {
                i--;
                continue;
            }
            hiddenCells[randomX][randomY] = bombs[i];
        }
    }

    private void setNeighborhoodNumbers(int x, int y) {
        int bombsAround = 0;
        bombsAround += checkNeighbors(x - 1, y - 1);
        bombsAround += checkNeighbors(x, y - 1);
        bombsAround += checkNeighbors(x + 1, y - 1);
        bombsAround += checkNeighbors(x - 1, y);
        bombsAround += checkNeighbors(x + 1, y);
        bombsAround += checkNeighbors(x - 1, y + 1);
        bombsAround += checkNeighbors(x, y + 1);
        bombsAround += checkNeighbors(x + 1, y + 1);
        if (bombsAround > 0 && hiddenCells[x][y] != 0) {
            hiddenCells[x][y] = bombsAround;
        }
    }

    private int checkNeighbors(int x, int y) {
        if (x >= 0 && y >= 0 && y < fieldSize && x < fieldSize && hiddenCells[x][y] == 0) {
            return 1;
        }
        return 0;
    }

    public void setNeighborhood() {
        for (int x = 0; x < hiddenCells.length; x++) {
            for (int y = 0; y < hiddenCells[x].length; y++) {
                setNeighborhoodNumbers(x, y);
            }
        }
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public int getBombsNumber() {
        return fieldSize;
    }

    public int[][] getHiddenCells() {
        return hiddenCells;
    }

    public byte[] getBombs() {
        return bombs;
    }

    /**
     * Print all cells to the screen. Use it if you need to see the
     * whole hidden filed to make testing more convenient for the console version.
     */
    @Deprecated // use only for testing
    public void printHiddenField(int[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }
}
