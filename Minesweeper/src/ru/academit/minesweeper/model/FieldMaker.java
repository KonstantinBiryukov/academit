package ru.academit.minesweeper.model;

public class FieldMaker {
    private int fieldSize = 9;
    private char[][] cells;

    public FieldMaker() {
        createField(fieldSize);
    }

    public FieldMaker(int fieldSize) {
        createField(fieldSize);
    }

    public char[][] createField(int fieldSize) {
        this.fieldSize = fieldSize;
        cells = new char[fieldSize][fieldSize];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = 'N';
            }
        }
        return cells;
    }

    public char[][] getCells() {
        return cells;
    }

    public int getFieldSize() {
        return fieldSize;
    }
}
