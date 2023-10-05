package com.games.tictactoe.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@SuperBuilder
public abstract class Player {
    private GameSymbol symbol;

    public abstract BoardCell makeMove(Board board);
}
