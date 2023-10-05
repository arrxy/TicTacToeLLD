package com.games.tictactoe.Exceptions;

public class InvalidPlayersException extends RuntimeException{
    private String mssg;
    public InvalidPlayersException(String mssg) {
        super("Invalid Players Exception");
        this.mssg = mssg;
    }
}
