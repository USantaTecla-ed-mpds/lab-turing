package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.MachinePlayer;

public abstract class MachinePlayerView extends PlayerView {

    public MachinePlayerView(MachinePlayer player) {
        super(player);
    }

    public int getColumn() {
        int column = ((MachinePlayer) this.player).getColumn();
        this.showColumnSelected(column);
        return column;
    }

    protected abstract void showColumnSelected(int column);
    
}
