package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.MinMaxPlayer;

public class MinMaxPlayerView extends MachinePlayerView {

    public MinMaxPlayerView(MinMaxPlayer player) {
        super(player);
    }

    public void showOptionSelected(int column) {
        MessageManager.getInstance().writeln("SHOW_MINMAX_COLUMN", String.valueOf(column + 1));
    }
}