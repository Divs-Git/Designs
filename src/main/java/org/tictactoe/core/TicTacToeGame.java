package org.tictactoe.core;

import org.tictactoe.board.Board;
import org.tictactoe.observer.IObserver;
import org.tictactoe.player.TicTacToePlayer;
import org.tictactoe.rules.StandardTicTacToeRules;
import org.tictactoe.rules.TicTacToeRules;

import java.util.*;

public class TicTacToeGame {
    private Board board;
    private Deque<TicTacToePlayer> players = new ArrayDeque<>();
    private List<IObserver> observers = new ArrayList<>();
    private TicTacToeRules rules;
    private boolean finished = false;

    public TicTacToeGame(int boardSize) {
        this.board = new Board(boardSize);
        this.rules = new StandardTicTacToeRules();
    }

    public void addPlayer(TicTacToePlayer player) {
        players.add(player);
    }

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void notifyAllObservers(String msg) {
        for (IObserver observer : observers) {
            observer.update(msg);
        }
    }

    public void play() {
        if (players.size() < 2) {
            System.out.println("Need at-least 2 players");
            return;
        }

        Scanner sc = new Scanner(System.in);

        while (!finished) {
            board.display();

            TicTacToePlayer currentPlayer = players.poll();
            System.out.print(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ") Enter row and col: ");

            int r = sc.nextInt();
            int c = sc.nextInt();

            if (rules.isValidMove(board, r, c)) {
                board.placeMark(r, c, currentPlayer.getSymbol());
                notifyAllObservers(currentPlayer.getName() + " played (" + r + "," + c + ")");

                if (rules.checkWinCondition(board, currentPlayer.getSymbol())) {
                    board.display();
                    System.out.println(currentPlayer.getName() + " wins!");
                    notifyAllObservers(currentPlayer.getName() + " wins!");
                    currentPlayer.incrementScore();
                    finished = true;
                } else if (rules.checkDrawCondition(board)) {
                    board.display();
                    System.out.println("Game Draw!");
                    notifyAllObservers("Game Draw!");
                } else {
                    players.offer(currentPlayer);
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }
}
