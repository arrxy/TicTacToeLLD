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
    public BoardCell(BoardCell boardCell) {
        this.row = boardCell.getRow();
        this.col = boardCell.getCol();
        this.symbol = boardCell.getSymbol();
    }
}
