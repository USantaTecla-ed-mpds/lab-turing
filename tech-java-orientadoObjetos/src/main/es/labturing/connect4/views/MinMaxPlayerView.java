package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.Turn;

public class MinMaxPlayerView extends MachinePlayerView {

    public MinMaxPlayerView(Turn turn) {
        super(turn);
    }

    public void showColumnSelected(int column) {
        MessageManager.getInstance().writeln("SHOW_MINMAX_COLUMN", String.valueOf(column + 1));
    }
}