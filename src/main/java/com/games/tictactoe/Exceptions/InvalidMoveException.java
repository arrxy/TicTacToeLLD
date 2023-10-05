package com.games.tictactoe.Exceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException() {
        super("The move was invalid");
    }
}
