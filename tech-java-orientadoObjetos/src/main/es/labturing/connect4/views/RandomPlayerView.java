package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.RandomPlayer;

public class RandomPlayerView extends MachinePlayerView {

    public RandomPlayerView(RandomPlayer player) {
        super(player);
    }

    public void showColumnSelected(int column) {
        MessageManager.getInstance().writeln("SHOW_RANDOM_COLUMN", String.valueOf(column + 1));
    }
}
