package models;

public class Turn {
    final static int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;
    private Board board;
    private int typeMachinePlayer=1;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
    }

    public void setTypeMachine(int type){
        this.typeMachinePlayer=type;
    }

    public void reset(int humanPlayers) {
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = i < humanPlayers ? new HumanPlayer(Color.get(i), this.board)
                    : (typeMachinePlayer==1 ? new RandomPlayer(Color.get(i), this.board):  new MinMaxPlayer(Color.get(i), this.board));
        }
        this.activePlayer = 0;
    }

    public void play(int column) {
        this.players[this.activePlayer].play(column);
        if (!this.board.isFinished()) {
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
}
