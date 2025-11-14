package org.SnakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    Board board;
    Queue<Player> players;
    Dice dice;
    boolean isFinished;

    public Game() {
        board = new Board(10,5,4);
        players = new LinkedList<>();
        players.add(new Player(1, 0));
        players.add(new Player(2, 0));
        dice = new Dice(1);
        isFinished = false;
    }

    public void playGame() {
        while (!isFinished) {
            Player currentPlayer = players.poll();
            System.out.println("Current player: " + currentPlayer.getId() + " position: " + currentPlayer.getCurrentPos());

            int diceNumber = dice.rollDice();

            int playerNewPosition = currentPlayer.getCurrentPos() + diceNumber;
            playerNewPosition = jumpCheck(playerNewPosition);
            currentPlayer.setCurrentPos(playerNewPosition);
            System.out.println("Current player: " + currentPlayer.getId() + " new position: " + currentPlayer.getCurrentPos());

            if(playerNewPosition >= board.cells.length * board.cells.length - 1) {
                System.out.println("Current player: " + currentPlayer.getId() + " wins!!!");
                isFinished = true;
            }
            players.offer(currentPlayer);
        }
    }

    public int jumpCheck(int pos) {
        if (pos > board.cells.length * board.cells.length - 1) return pos;

        Cell cell = board.getCell(pos);
        if(cell.jump != null && cell.jump.start == pos) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "ladder" : "snake";
            System.out.println("jump by :" + jumpBy);
            return cell.jump.end;
        }

        return pos;
    }
}
