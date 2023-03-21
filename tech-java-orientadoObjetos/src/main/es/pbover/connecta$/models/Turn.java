package main.es.pbover.connecta$.models;

public class Turn {
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

    public void setPlayers(Player player){
        for (int i = 0; i < this.players.length; i++) {
            if(this.players[i] == null){
                this.players[i] = player;
                break; //TODO
            }
        }
    }

    public Color getNextColor(){
        for (int i = 0; i < this.players.length; i++) {
            if(this.players[i] == null){
                //return Color.get(i);
                return Color.values()[i];
            }
        }
        return null;
    }
}
