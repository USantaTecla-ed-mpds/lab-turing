package main.es.labturing.connect4.models;

public class GameState {

    private Board board;
    private Turn turn;

    public GameState(Board board,Turn turn){
        this.board.setColors(board.getColors().clone());
        this.board.setLastDrop(board.getLastDrop());
        this.turn.setPlayers(turn.getPlayers().clone());
        this.turn.setActivePlayerIndex(turn.getActivePlayerIndex());
    }

    public Board getBoard() {
        return board;
    }

    public Turn getTurn() {
        return turn;
    }
    
}
