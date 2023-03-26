package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.MinMaxPlayer;

public class MinMaxPlayerView extends PlayerView {

    public MinMaxPlayerView(MinMaxPlayer player) {
        super(player);
    }

    public int getColumn() {
        this.showPlayerTurn();
        int column = ((MinMaxPlayer) this.player).getColumn();
        MessageManager.getInstance().writeln("SHOW_MINMAX_COLUMN", String.valueOf(column + 1));
        return column;
    }
}