package org.SnakeAndLadder;

import java.util.Random;

public class Dice {
    private int diceCount;
    Random random = new Random();

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int total = 0;

        for(int i = 1 ; i <= diceCount ; i++) {
            total += random.nextInt(6) + 1;
        }

        return total;
    }
}
