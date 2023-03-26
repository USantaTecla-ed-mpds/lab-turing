package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.Player;

public class MachinePlayerView<E> extends PlayerView {

    public MachinePlayerView(E player) {
        super(player);
    }

    public int getColumn() {
        this.showPlayerTurn();
        int column = ((E) this.player).getColumn();
        MessageManager.getInstance().writeln("SHOW_"+E+"_COLUMN", String.valueOf(column + 1)); //
        return column;
    }
    
}
