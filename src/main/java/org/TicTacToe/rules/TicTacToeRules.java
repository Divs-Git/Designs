package org.TicTacToe.rules;

import org.TicTacToe.board.Board;
import org.TicTacToe.core.Symbol;

public interface TicTacToeRules {
    boolean isValidMove(Board board, int row, int col);
    boolean checkWinCondition(Board board, Symbol symbol);
    boolean checkDrawCondition(Board board);
}
