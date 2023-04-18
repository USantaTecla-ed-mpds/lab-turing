package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.Turn;

public abstract class PlayerView {
    protected Turn turn;

    public PlayerView(Turn turn) {
        this.turn = turn;
    }

    protected void showWinner() {
        MessageManager.getInstance().writeln("PLAYER_WIN", new ColorView(this.turn.getActivePlayer().getColor()).toString());
    }

    protected void showPlayerTurn() {
        MessageManager.getInstance().writeln("TURN", new ColorView(this.turn.getActivePlayer().getColor()).toString());
    }

    public abstract int getColumn();

}
