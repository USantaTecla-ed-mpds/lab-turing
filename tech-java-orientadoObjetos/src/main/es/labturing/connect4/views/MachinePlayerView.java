package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.MachinePlayer;
import main.es.labturing.connect4.models.Turn;

public abstract class MachinePlayerView extends PlayerView {

    public MachinePlayerView(Turn turn) {
        super(turn);
    }

    public int getColumn() {
        int column = ((MachinePlayer) this.turn.getActivePlayer()).getColumn();
        this.showColumnSelected(column);
        return column;
    }

    protected abstract void showColumnSelected(int column);
    
}
