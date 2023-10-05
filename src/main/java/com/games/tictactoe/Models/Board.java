package com.games.tictactoe.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Board {
    private Integer size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(Integer size) {
        this.size = size;
        this.cells = initializeCells(size);
    }

    private List<List<BoardCell>> initializeCells(Integer size) {
        // from size 3 => create list of 3x3
        return Collections.nCopies(size, Collections.nCopies(size, new BoardCell()));
    }

    public boolean isEmpty(Integer row, Integer col) {
       return cells.get(row).get(col).getSymbol() == null;
    }

    public void update(BoardCell move) {
        cells.get(move.getRow()).get(move.getCol()).setSymbol(move.getSymbol());
    }
}
