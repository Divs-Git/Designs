package org.TicTacToe;

import org.TicTacToe.core.Symbol;
import org.TicTacToe.core.TicTacToeFactory;
import org.TicTacToe.core.TicTacToeGame;
import org.TicTacToe.observer.ConsoleNotifier;
import org.TicTacToe.player.TicTacToePlayer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==== Tic Tac Toe ====");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size (3 for 3 X 3): ");
        int size = sc.nextInt();

        TicTacToeGame game = TicTacToeFactory.createStandardGame(size);
        game.addObserver(new ConsoleNotifier());

        game.addPlayer(new TicTacToePlayer(1, "Divyansh", new Symbol('X')));
        game.addPlayer(new TicTacToePlayer(2, "Ankita", new Symbol('O')));

        game.play();
    }
}
