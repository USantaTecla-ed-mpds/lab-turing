package main.es.labturing.connect4.models;

import java.io.Serializable;

public class TurnState implements Serializable{

    private Player[] players;
    private int activePlayerIndex;

    public TurnState(Player[] players, int activePlayerIndex){
        this.players = new Player[Turn.NUMBER_PLAYERS];
        for (int i = 0; i < players.length; i++) {
            this.players[i] = players[i];
        }
        this.activePlayerIndex = activePlayerIndex;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public int getActivePlayerIndex() {
        return this.activePlayerIndex;
    }

    public TurnState clone() {
        return new TurnState(this.players, this.activePlayerIndex);
    }
}
