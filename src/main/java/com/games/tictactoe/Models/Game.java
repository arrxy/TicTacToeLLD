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

@Getter
public class Game {

    private static final Integer PLAYER_COUNT = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.NOT_STARTED;
    private Board board;
    private List<Player> players = new ArrayList<>();
    private GameStatus status;
    private Integer nextPlayerIdx = 0;

    private Game() {}
    public void start() {
        // ASSIGN A RANDOM VALUE TO THE NEXT PLAYER
        // GENERATE A RANDOM VALUE -> 0 or 1
        Integer playerTurn = (int)Math.random() * players.size();
        // SET THE STATUS TO IN_PROGRESS
        status = GameStatus.IN_PROGRESS;
    }
    public void makeMove() {
        BoardCell move = getNextMove();
        board.update(move);
        // Check for winner
        if (checkWinner()) {
            status = GameStatus.FINISHED;
            System.out.println("HURRAYYYYYYY !!!! Player " + move.getSymbol() + " WON ");
        }
        if (checkDraw()) {
            status = GameStatus.FINISHED;
            System.out.println("GAME DRAW :'(");
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
        return checkDiagonals() || checkRows() || checkCols();
    }

    private boolean checkDiagonals() {
        return checkLeftDiagonal() || checkRightDiagonal();
    }
    private boolean checkLeftDiagonal() {
        int size = board.getSize();
        GameSymbol symbol = board.getCells().get(0).get(0).getSymbol();
        for (int i = 0; i < size; ++i) {
                GameSymbol currSymbol = board.getCells().get(i).get(i).getSymbol();
                if (currSymbol == null || !currSymbol.equals(symbol)) {
                    return false;
                }
        }
        return true;
    }
    private boolean checkRightDiagonal() {
        int size = board.getSize();
        GameSymbol symbol = board.getCells().get(0).get(size - 1).getSymbol();
        int i = 0, j = size - 1;
        while (i < size) {
            GameSymbol currSymbol = board.getCells().get(i).get(j).getSymbol();
            if (currSymbol == null || !currSymbol.equals(symbol)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
    private boolean checkRows() {
        int size = board.getSize();
        boolean result = false;
        for (int i = 0; i < size; ++i) {
            result |= checkIthRow(i);
        }
        return result;
    }

    private boolean checkIthRow(int row) {
        boolean result = true;
        for (int i = 0; i < board.getSize() - 1; ++i) {
            GameSymbol currSymbol = board.getCells().get(row).get(i).getSymbol();
            GameSymbol nextSymbol = board.getCells().get(row).get(i + 1).getSymbol();
            result = result && (currSymbol != null && currSymbol.equals(nextSymbol));
        }
        return result;
    }

    private boolean checkCols() {
        int size = board.getSize();
        boolean result = false;
        for (int i = 0; i < size; ++i) {
            result |= checkIthCol(i);
        }
        return result;
    }

    private boolean checkIthCol(int col) {
        boolean result = true;
        for (int i = 0; i < board.getSize() - 1; ++i) {
            GameSymbol currSymbol = board.getCells().get(i).get(col).getSymbol();
            GameSymbol nextSymbol = board.getCells().get(i + 1).get(col).getSymbol();
            result = result && (currSymbol != null && currSymbol.equals(nextSymbol));
        }
        return result;
    }

    private boolean checkDraw() {
        for (int i = 0; i < board.getSize(); ++i) {
            for (int j = 0; j < board.getSize(); ++j) {
                if (board.getCells().get(i).get(j).getSymbol() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIdx);
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
