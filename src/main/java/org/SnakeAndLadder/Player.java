package org.SnakeAndLadder;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Player {
    private int id;
    private int currentPos;

    public Player(int id, int currentPos) {
        this.id = id;
        this.currentPos = currentPos;
    }
}
