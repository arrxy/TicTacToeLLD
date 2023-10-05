package com.games.tictactoe.Strategies.playing;

import com.games.tictactoe.Models.Board;
import com.games.tictactoe.Models.BoardCell;

public interface PlayingStrategy {
    BoardCell makeMove(Board board);
}
