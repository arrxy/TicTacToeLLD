package com.games.tictactoe.Models;

import com.games.tictactoe.Strategies.playing.PlayingStrategy;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class BotPlayer extends Player{
    private GameLevel level;
    private PlayingStrategy playingStrategy;

    public BotPlayer(GameSymbol symbol, GameLevel level, PlayingStrategy playingStrategy) {
        super(symbol);
        this.level = level;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public BoardCell makeMove(Board board) {
        for (int i = 0; i < board.getCells().size(); ++i) {
            for (int j = 0; j < board.getCells().size(); ++j) {
                BoardCell cell = board.getCells().get(i).get(j);
                if (cell.getSymbol() == null) {
                    return new BoardCell(i, j, getSymbol());
                }
            }
        }
        return null;
    }
}
