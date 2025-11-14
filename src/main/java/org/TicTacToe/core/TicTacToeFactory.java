package org.TicTacToe.core;

public class TicTacToeFactory {
    public static TicTacToeGame createStandardGame(int boardSize) {
        return new TicTacToeGame(boardSize);
    }
}
