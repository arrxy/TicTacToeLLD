package com.games.tictactoe;

import com.games.tictactoe.Models.*;
import com.games.tictactoe.Strategies.playing.RandomPlayingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    private static final int BOARD_SIZE = 3;
    @Test
    public void testCreateGame() {
        Game game = Game.builder().withSize(BOARD_SIZE)
                .withPlayer(
                        HumanPlayer.builder()
                                .user(new User())
                                .symbol(GameSymbol.X)
                                .build()
                )
                .withPlayer(
                        BotPlayer.builder().level(GameLevel.EASY)
                                .playingStrategy(new RandomPlayingStrategy())
                                .symbol(GameSymbol.O)
                                .build()
                )
                .build();
//        Game game = Game.buildGame().build();
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
