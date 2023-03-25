package connect4.models;

import java.io.Serializable;

public class Turn implements Serializable {
    final static int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;
    private Board board;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
    }

    public void reset() {
        this.activePlayer = 0;
    }

    public void play(int column) {
        this.players[this.activePlayer].play(column);
        if (!this.board.isGameFinished()) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    public Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

    public Board getBoard() {
        return this.board;
    }

    public int getNumberPlayers() {
        return Turn.NUMBER_PLAYERS;
    }

    public void addPlayer(Player player) {
        int i = 0;
        while (i < this.players.length && this.players[i] != null) {
            i++;
        }
        if (i < this.players.length) {
            player.setColor(Color.values()[i]);
            this.players[i] = player;
        }
    }
}
