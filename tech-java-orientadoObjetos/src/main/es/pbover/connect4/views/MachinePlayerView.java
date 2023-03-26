package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.MachinePlayer;

public abstract class MachinePlayerView extends PlayerView {

    public MachinePlayerView(MachinePlayer player) {
        super(player);
    }

    public int getColumn() {
        this.showPlayerTurn();
        int column = ((MachinePlayer) this.player).getColumn();
        this.showOptionSelected(column);
        return column;
    }

    protected abstract void showOptionSelected(int column);
    
}
