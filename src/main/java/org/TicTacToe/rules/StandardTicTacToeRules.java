package org.TicTacToe.rules;

import org.TicTacToe.board.Board;
import org.TicTacToe.core.Symbol;

public class StandardTicTacToeRules implements TicTacToeRules {
    @Override
    public boolean isValidMove(Board board, int row, int col) {
        return board.isCellEmpty(row, col);
    }

    @Override
    public boolean checkWinCondition(Board board, Symbol symbol) {
        int n = board.getSize();

        // rows
        for(int i = 0 ; i < n ; i++) {
            boolean win = true;
            for(int j = 0 ; j < n ; j++) {
                if(board.getCell(i,j) != symbol) win = false;
            }
            if(win) return true;
        }

        // cols
        for(int j = 0 ; j < n ; j++) {
            boolean win = true;
            for(int i = 0 ; i < n ; i++) {
                if(board.getCell(i,j) != symbol) win = false;
            }
            if(win) return true;
        }

        // diagonal
        boolean win = true;
        for(int i = 0 ; i < n ; i++) {
            if(board.getCell(i,i) != symbol) win = false;
        }
        if(win) return true;

        // anti-diagonal
        win = true;
        for(int i = 0 ; i < n ; i++) {
            if(board.getCell(i, n - i - 1) != symbol) win = false;
        }
        return win;
    }

    @Override
    public boolean checkDrawCondition(Board board) {
        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board.getCell(i, j) == board.getEmptyCell()) return false;
            }
        }
        return true;
    }
}
