package main.es.labturing.connect4.models;

import java.io.Serializable;

public class GameState implements Serializable{

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

    public GameState clone() {
        return new GameState(this.getBoardState().clone(),this.getTurnState().clone());
    }
}
