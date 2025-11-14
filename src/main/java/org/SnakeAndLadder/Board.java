package org.SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int boardSize, int noOfSnakes, int noOfLadder) {
        initializeCells(boardSize);
        addSnakesAndLadder(noOfSnakes, noOfLadder);
    }

    private void addSnakesAndLadder(int noOfSnakes, int noOfLadder) {
        while(noOfSnakes > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells .length - 1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells .length - 1);

            if(start <= end) continue;

            Jump snakeObj = new Jump();
            snakeObj.setStart(start);
            snakeObj.setEnd(end);

            Cell cell = getCell(start);
            cell.jump = snakeObj;

            noOfSnakes--;
        }

        while(noOfLadder > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells .length - 1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells .length - 1);

            if(start >= end) continue;

            Jump ladderObj = new Jump();
            ladderObj.setStart(start);
            ladderObj.setEnd(end);

            Cell cell = getCell(start);
            cell.jump = ladderObj;

            noOfLadder--;
        }
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i = 0 ; i < boardSize ; i++) {
            for (int j = 0 ; j < boardSize ; j++) {
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }

    public Cell getCell(int pos) {
        int row = pos / cells.length;
        int col = pos % cells.length;
        return cells[row][col];
    }
}
