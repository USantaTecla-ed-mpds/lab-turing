package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.MinMaxPlayer;

public class MinMaxPlayerView extends MachinePlayerView {

    public MinMaxPlayerView(MinMaxPlayer player) {
        super(player);
    }

    public void showColumnSelected(int column) {
        MessageManager.getInstance().writeln("SHOW_MINMAX_COLUMN", String.valueOf(column + 1));
    }
}