package org.TicTacToe.player;

import lombok.Getter;
import org.TicTacToe.core.Symbol;

@Getter
public class TicTacToePlayer {
    private int id;
    private String name;
    private Symbol symbol;
    private int score;

    public TicTacToePlayer(int id, String name, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    public void incrementScore() {
        score++;
    }
}
