package com.games.tictactoe.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

// EXTRINSIC STATE
@SuperBuilder
public class HumanPlayer extends Player {
    private User user;

//    @Builder.Default
//    private Scanner scanner = new Scanner(System.in);
    public HumanPlayer(GameSymbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    public BoardCell makeMove(Board board) {
        System.out.println("ENTER ROW AND COLUMN :: ");
        Scanner scanner = new Scanner(System.in);
        Integer row = scanner.nextInt();
        Integer col = scanner.nextInt();
        return new BoardCell(row, col, getSymbol());
    }
}
