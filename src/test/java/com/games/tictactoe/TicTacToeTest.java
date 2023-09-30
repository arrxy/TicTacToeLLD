package com.games.tictactoe;

import com.games.tictactoe.Models.Board;
import com.games.tictactoe.Models.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    @Test
    public void testCreateGame() {
//        Board board = new Board();
//       Game game = new Game();
    }

    @Test
    public void testCreateBoard() {
        Board board = new Board(3);
        Integer rowSize = board.getCells().get(0).size();
        Integer colSize = board.getSize();
        assertEquals(3, rowSize);
        assertEquals(3, colSize);
    }
}
