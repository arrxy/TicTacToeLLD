package com.games.tictactoe.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardCell {
    private Integer row;
    private Integer col;
    private GameSymbol symbol;

    public BoardCell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }
}
