package ru.academit.minesweeper.text;

import ru.academit.minesweeper.gui.IGameActions;
import ru.academit.minesweeper.model.FieldMaker;
import ru.academit.minesweeper.model.HiddenFieldMaker;

import java.util.Scanner;

public class GameFieldText implements IGameActions {
    HiddenFieldMaker hiddenField;
    FieldMaker fieldMaker;
    private int fieldSize = 9;
    private int bombsNumber = 10;
    private int[][] hiddenCells;
    private char[][] cells;
    private boolean isGameOver = false;
    private int x;
    private int y;

    public GameFieldText() {
        System.out.println("Hello and Welcome to MINESWEEPER!");
        System.out.println();
        System.out.printf("Initial size of the filed is %d x %d. Initial number of bombs is %d. ", fieldSize, fieldSize, bombsNumber);
        System.out.println();
        System.out.println("* Would you like to change the size of the play field ?"
                + System.lineSeparator() + "- Type 'Y'(ENG) if you'd like to change it;" + System.lineSeparator() +
                "- Type any other symbol and the initial size will be applied and the game will be started;");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.equals("Y") || answer.equals("y")) {
            System.out.println("What size of the field would you like to get ? ");
            fieldSize = scanner.nextInt();
            if (fieldSize < 3 || fieldSize > 100) {
                throw new IndexOutOfBoundsException("Set up size of the fields greater than 3 and less than 100");
            }
            System.out.println("How many bombs you'd like to have in the game ? ");
            bombsNumber = scanner.nextInt();
            if (bombsNumber >= fieldSize * fieldSize - 1) {
                throw new IndexOutOfBoundsException("The quantity of bombs should be less than size of the field");
            }
            System.out.printf("Field's size is equal to %d x %d now", fieldSize, fieldSize);
            System.out.println();
            System.out.printf("Number of bombs is %d now", bombsNumber);
            System.out.println();
        }
        fieldMaker = new FieldMaker(fieldSize);
        hiddenField = new HiddenFieldMaker(fieldSize, bombsNumber);
        printField();
        typeCoordinatesRequest();
        firstClick(x - 1, y - 1);
        hiddenField.printHiddenField(hiddenCells); // for test

        printField();

        while (!isGameOver) {
            typeCoordinatesRequest();
            click(x - 1, y - 1);
            printField();
            if (isGameOver) {
                System.out.println();
                System.out.println("\t\tGAME OVER");
                printField();
                System.exit(0);
            }
        }
    }

    public void typeCoordinatesRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("type coordinates to open a cell");
        System.out.print("X: ");
        y = scanner.nextInt();
        System.out.print("Y: ");
        x = scanner.nextInt();

        if (x < 1 || x > fieldSize || y < 1 || y > fieldSize) {
            System.out.println("You have to choose coordinates from 1 to " + fieldSize +
                    " And it should be an integer");
            typeCoordinatesRequest();
        }
    }

    public void printField() {
        int count = 1;
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(count++ + "  ");
        }
        System.out.println();
        for (int i = 0; i < fieldSize * 3.2; i++) {
            System.out.print("-");
        }
        System.out.println();

        cells = fieldMaker.getCells();
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(i + 1 + "| ");
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(cells[i][j] + "  ");
            }
            System.out.println();
        }
    }

    @Override
    public void firstClick(int x, int y) {
        hiddenCells = hiddenField.getHiddenCells();
        hiddenField.setBombs(x, y);
        hiddenField.setNeighborhood();
        openCells(x, y);
    }

    @Override
    public void click(int x, int y) {
        openCells(x, y);
    }

    @Override
    public void openCells(int x, int y) {
        if (hiddenCells[x][y] > 8) {
            cells[x][y] = ' ';
            openNeighborEmptyCells(x, y);
        } else if (hiddenCells[x][y] > 0 && hiddenCells[x][y] <= 8) {
            int cell = hiddenCells[x][y];
            cells[x][y] = Integer.toString(cell).charAt(0);
        } else if (hiddenCells[x][y] == 0) {
            cells[x][y] = '*';
            endGame();
        }
    }

    @Override
    public void openNeighborEmptyCells(int x, int y) {
        checkEmptyNeighbors(x - 1, y - 1);
        checkEmptyNeighbors(x, y - 1);
        checkEmptyNeighbors(x + 1, y - 1);
        checkEmptyNeighbors(x - 1, y);
        checkEmptyNeighbors(x + 1, y);
        checkEmptyNeighbors(x - 1, y + 1);
        checkEmptyNeighbors(x, y + 1);
        checkEmptyNeighbors(x + 1, y + 1);
    }

    @Override
    public void checkEmptyNeighbors(int x, int y) {
        if (x >= 0 && y >= 0 && y < fieldSize && x < fieldSize) {
            if (hiddenCells[x][y] > 8) {
                cells[x][y] = ' ';
            } else if (hiddenCells[x][y] > 0 && hiddenCells[x][y] <= 8) {
                int cell = hiddenCells[x][y];
                cells[x][y] = Integer.toString(cell).charAt(0);
            }
        }
    }

    @Override
    public void endGame() {
        isGameOver = true;
        openAllCells();
    }

    @Override
    public void openAllCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (hiddenCells[i][j] > 8) {
                    cells[i][j] = ' ';
                } else if (hiddenCells[i][j] > 0 && hiddenCells[i][j] <= 8) {
                    int cell = hiddenCells[i][j];
                    cells[i][j] = Integer.toString(cell).charAt(0);
                } else if (hiddenCells[i][j] == 0) {
                    cells[i][j] = '*';
                }
            }
        }
    }
}