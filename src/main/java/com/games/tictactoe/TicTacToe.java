package com.games.tictactoe;

import com.games.tictactoe.Exceptions.InvalidSymbolException;
import com.games.tictactoe.Models.*;
import com.games.tictactoe.Strategies.playing.RandomPlayingStrategy;

import java.util.Scanner;

// Client Code
public class TicTacToe {
    private static final Integer BOARD_SIZE = 3;
    public static void main(String[] args) {
        // ASK FOR USER INPUT => Name, Email, Symbol
        HumanPlayer player = getUserInput();
        System.out.println("Player ready to play :: " + player.getSymbol());
        // CREATE A GAME
        Game game = createGame(player);
        game.start();

        // INITIALIZE THE BOT PLAYER
        // H vs B

        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            Player nextPlayer = game.getNextPlayer();
            System.out.println("NEXT PLAYER :: " + nextPlayer.getSymbol());
            game.makeMove();
            game.getBoard().printBoard();
        }
        // START A GAME
        // ASSIGN THE FIRST PLAYER
        // MARK THE GAME IN PROGRESS
        // START PLAYING
    }

    private static Game createGame(HumanPlayer humanPlayer) {
        return Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(BotPlayer.builder()
                        .symbol(decideGameSymbol(humanPlayer.getSymbol()))
                        .level(GameLevel.EASY)
                        .playingStrategy(new RandomPlayingStrategy())
                        .build()
                )
                .build();
    }

    // GET THE LIST OF ALL SYMBOLS
    // FILTER OUT USER'S SYMBOL
    // RANDOMLY SELECT ONE FROM THE LIST
    private static GameSymbol decideGameSymbol(GameSymbol symbol) {
        if (symbol.equals(GameSymbol.X)) return GameSymbol.O;
        return GameSymbol.X;
    }
    private static HumanPlayer getUserInput() {
        System.out.println("Welcome to TicTacToe");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Name :: ");
        String name = scanner.nextLine();

        System.out.println("Enter Email ::");
        String email = scanner.nextLine();

        System.out.println("Enter Symbol");
        GameSymbol symbol = null;
        try {
            symbol = GameSymbol.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            throw new InvalidSymbolException();
        }

        User user =  new User(name, email, null);
        return new HumanPlayer(symbol, user);
    }
}
