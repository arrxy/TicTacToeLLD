package com.games.tictactoe.Models;

import com.games.tictactoe.Exceptions.InvalidMoveException;
import com.games.tictactoe.Exceptions.InvalidPlayersException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {

    private static final Integer PLAYER_COUNT = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.NOT_STARTED;
    private Board board;
    private List<Player> players = new ArrayList<>();
    private GameStatus status;
    private Integer nextPlayerIdx = 0;

    private Game() {}
    public void start() {}
    public void makeMove() {
        BoardCell move = getNextMove();
        board.update(move);
        // Check for winner
        if (checkWinner()) {
            status = GameStatus.FINISHED;
        }
        if (checkDraw()) {
            status = GameStatus.FINISHED;
        }
        nextPlayerIdx = (nextPlayerIdx + 1) % players.size();
        // Check for draw 
    }

    private void validateMove(BoardCell move) {
        if (!board.isEmpty(move.getRow(), move.getCol())) {
            throw new InvalidMoveException();
        }
    }

    private BoardCell getNextMove() {
        Player player = players.get(nextPlayerIdx);
        BoardCell move = player.makeMove(board);
        validateMove(move);
        return move;
    }

    private boolean checkWinner() {
        return false ;
    }

    private boolean checkDraw() {
        return false;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Game game = new Game();

        public Builder () {
            game = new Game();
        }

        public Builder withSize(int size) {
            this.game.board = new Board(size);
            return this;
        }
        public Builder withPlayer(Player player) {
             this.game.players.add(player);
             return this;
        }

        public Game build() {
            boolean isValid = validate();
            if (!isValid) {
                throw new InvalidPlayersException("Not Valid");
            }
            Game newGame = new Game();
            newGame.board = game.board;
            newGame.players = game.players;
            newGame.status = DEFAULT_STATUS;
            return newGame;
        }

        public boolean validate() {
            if (game.players.size() != PLAYER_COUNT) {
                return false;
            }
            // If symbols are unique
            Set<GameSymbol> symbols = game.players.stream()
                    .map(Player::getSymbol)
                    .collect(Collectors.toSet());
            if (symbols.size() != PLAYER_COUNT) {
                return false;
            }
            return true;
        }
    }
}
