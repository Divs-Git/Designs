package org.tictactoe.rules;

import org.tictactoe.board.Board;
import org.tictactoe.core.Symbol;

public interface TicTacToeRules {
    boolean isValidMove(Board board, int row, int col);
    boolean checkWinCondition(Board board, Symbol symbol);
    boolean checkDrawCondition(Board board);
}
