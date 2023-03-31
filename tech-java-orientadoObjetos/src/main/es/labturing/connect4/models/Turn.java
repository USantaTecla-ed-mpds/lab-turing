package main.es.labturing.connect4.models;

public class Turn {
    final static int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;
    private Board board;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
    }

    public void resetPlayers() {
        for (int i = 0; i < this.players.length; i++){
            this.players[i]=null;
        }
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
        boolean playerSetted = false;
        for (int i = 0; i < this.players.length && playerSetted == false; i++) {
            if (this.players[i] == null) {
                player.setColor(Color.values()[i]);
                this.players[i] = player;
                playerSetted = true;
            }
        }
    }
}
