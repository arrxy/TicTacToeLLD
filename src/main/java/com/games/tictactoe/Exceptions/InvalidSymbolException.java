package com.games.tictactoe.Exceptions;

public class InvalidSymbolException extends RuntimeException {
    public InvalidSymbolException() {
        super("Invalid Symbol. Please enter correct value");
    }
}
