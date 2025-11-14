package org.TicTacToe.core;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Symbol {
    private char mark;

    public Symbol(char mark) {
        this.mark = mark;
    }
}
