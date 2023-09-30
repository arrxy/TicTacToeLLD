package com.games.tictactoe.Models;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Game {
    private Board board;
    private List<Player> player = new ArrayList<>();
    private GameStatus gameStatus;

    public void start() {}
    public void makeMove() {}

    private Player checkWinner() {
        return null;
    }

    private boolean checkDraw() {
        return false;
    }
}
