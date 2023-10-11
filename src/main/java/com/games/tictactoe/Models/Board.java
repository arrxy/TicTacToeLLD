package com.games.tictactoe.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

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
        List<List<BoardCell>> board = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            List<BoardCell> row = new ArrayList<>();
            for (int j = 0; j < size; ++j) {
                row.add(new BoardCell(i, j));
            }
            board.add(row);
        }
        return board;
    }

    public boolean isEmpty(Integer row, Integer col) {
       return cells.get(row).get(col).getSymbol() == null;
    }

    public void update(BoardCell move) {
        BoardCell cell = cells.get(move.getRow()).get(move.getCol());
        cell.setSymbol(move.getSymbol());
    }

    public void printBoard() {
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.size(); ++j) {
                GameSymbol symbol = cells.get(i).get(j).getSymbol();
                if (symbol == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + symbol + " | ");
                }
            }
            System.out.println();
        }
    }

    public List<BoardCell> fetchEmptyCell() {
        return cells
                .stream()
                .flatMap(List::stream)
                .filter(cell -> cell.getSymbol() == null)
                .toList();
    }
}
