package org.tictactoe.core;

public class TicTacToeFactory {
    public static TicTacToeGame createStandardGame(int boardSize) {
        return new TicTacToeGame(boardSize);
    }
}
