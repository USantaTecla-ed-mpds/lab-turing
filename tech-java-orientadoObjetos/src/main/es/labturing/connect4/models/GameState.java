package main.es.labturing.connect4.models;

public class GameState {

    private BoardState boardState;
    private TurnState turnState;

    public GameState(BoardState boardState,TurnState turnState){
        this.boardState = boardState;
        this.turnState = turnState;
    }

    public BoardState getBoardState() {
        return this.boardState;
    }

    public TurnState getTurnState() {
        return this.turnState;
    }
}
