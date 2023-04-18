package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.Turn;

public class RandomPlayerView extends MachinePlayerView {

    public RandomPlayerView(Turn turn) {
        super(turn);
    }

    public void showColumnSelected(int column) {
        MessageManager.getInstance().writeln("SHOW_RANDOM_COLUMN", String.valueOf(column + 1));
    }
}
