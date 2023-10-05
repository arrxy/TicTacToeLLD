package com.games.tictactoe.Models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

// EXTRINSIC STATE
@SuperBuilder
public class HumanPlayer extends Player {
    private User user;
    public HumanPlayer(GameSymbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    public BoardCell makeMove(Board board) {
        return null;
    }
}
