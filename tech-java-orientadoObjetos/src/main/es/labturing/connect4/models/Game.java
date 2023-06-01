package main.es.labturing.connect4.models;

import java.io.Serializable;

import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.types.PlayerType;

public class Game implements Serializable{

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

    public boolean isWinner() {
        return this.board.isWinner();
    }

    public boolean isGameFinished() {
        return this.board.isGameFinished();
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public void addPlayer(PlayerType playerType) {
        this.turn.addPlayer(playerType);
    }

    public void resetPlayers() {
        this.turn.resetPlayers();
    }

    public void resetPlayersIndex() {
        this.turn.resetPlayersIndex();
        ;
    }

    public int getNumberPlayers() {
        return this.turn.getNumberPlayers();
    }

    public void dropToken(int column) {
        this.turn.dropToken(column);
    }

    public int getActiveMachineColumn() {
        MachinePlayer machinePlayer = (MachinePlayer) this.turn.getActivePlayer();
        return machinePlayer.getColumn();
    }

    public PlayerType getActivePlayerType() {
        return this.turn.getActivePlayer().getType();
    }

    public Color getActivePlayerColor() {
        return this.turn.getActivePlayer().getColor();
    }

    public boolean isColumnComplete(int column) {
        return this.turn.getActivePlayer().isComplete(column);
    }

    public GameState getState() {
        return new GameState(this.board.getState(), this.turn.getState());
    }

    public void setState(GameState gameState) {
        this.board.setState(gameState.getBoardState());
        this.turn.setState(gameState.getTurnState());
    }

    public Board getBoard() {
        return this.board;
    }

    public Turn getTurn() {
        return this.turn;
    }

}
