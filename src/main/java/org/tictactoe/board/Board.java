package org.tictactoe.board;

import lombok.Getter;
import org.tictactoe.core.Symbol;

@Getter
public class Board {
    private Symbol[][] grid;
    private int size;
    private final Symbol emptyCell = new Symbol('_');

    public Board(int size) {
        this.size = size;
        grid = new Symbol[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = emptyCell;
            }
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return inBounds(row, col) && grid[row][col] == emptyCell;
    }

    public boolean placeMark(int row, int col, Symbol symbol) {
        if (!isCellEmpty(row, col)) return false;
        grid[row][col] = symbol;
        return true;
    }

    public Symbol getCell(int row, int col) {
        return inBounds(row, col) ? grid[row][col] : emptyCell;
    }

    private boolean inBounds(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public void display() {
        System.out.print("\n ");
        for (int i = 0; i < size; i++) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getMark() + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
