package main.es.labturing.connect4.models;

import java.io.Serializable;

import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.types.PlayerType;

public class Turn implements Serializable {
    public final static int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayerIndex;
    private Board board;
    private PlayersPrototype playersPrototype;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
        this.playersPrototype = new PlayersPrototype(this.board);
    }

    public void resetPlayers() {
        for (int i = 0; i < this.players.length; i++) {
            this.players[i] = null;
        }
        this.resetPlayersIndex();
    }

    public void resetPlayersIndex() {
        this.activePlayerIndex = 0;
    }

    public void dropToken(int column) {
        this.players[this.activePlayerIndex].dropToken(column);
        if (!this.board.isGameFinished()) {
            this.activePlayerIndex = (this.activePlayerIndex + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    public void addPlayer(PlayerType playerType) {
        Player player = this.playersPrototype.getPlayer(playerType);
        boolean playerSetted = false;
        for (int i = 0; i < this.players.length && playerSetted == false; i++) {
            if (this.players[i] == null) {
                player.setColor(Color.values()[i]);
                this.players[i] = player;
                playerSetted = true;
            }
        }
    }

    public Player getActivePlayer() {
        return this.players[this.activePlayerIndex];
    }

    public int getActivePlayerIndex() {
        return this.activePlayerIndex;
    }

    public TurnState getState() {
        return new TurnState(players, activePlayerIndex);
    }

    public void setState(TurnState turnState) {
        this.players = turnState.getPlayers();
        this.activePlayerIndex = turnState.getActivePlayerIndex();
    }

    public void setActivePlayerIndex(int activePlayerIndex) {
        this.activePlayerIndex = activePlayerIndex;
    }

    public int getPlayerType(int index){
        return this.players[index].getType().ordinal();
    }

}
