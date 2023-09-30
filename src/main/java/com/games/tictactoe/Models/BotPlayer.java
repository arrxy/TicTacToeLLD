package com.games.tictactoe.Models;

public class BotPlayer extends Player{
    private GameLevel level;

    private BotPlayer(GameSymbol symbol, GameLevel level) {
        super(symbol);
        this.level = level;
    }

}
