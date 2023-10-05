package com.games.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCell {
    private Integer row;
    private Integer col;
    private GameSymbol symbol;
}
