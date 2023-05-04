package main.es.labturing.connect4.models;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.resetPlayers();
    }

    public Board getBoard() {
        return board;
    }

    public Turn getTurn() {
        return turn;
    }

    public GameState getState(){
        BoardState boardState = this.board.getState();
        TurnState turnState = this.turn.getState();
        return new GameState(boardState, turnState);
    }

    public void setState(GameState gameState) {
        this.board.setState(gameState.getBoardState());
        this.turn.setState(gameState.getTurnState());
    }

}
