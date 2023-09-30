package com.games.tictactoe.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
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
}
