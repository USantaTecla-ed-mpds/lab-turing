package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.RandomPlayer;

public class RandomPlayerView extends PlayerView {

    public RandomPlayerView(RandomPlayer player) {
        super(player);
    }

    public int getColumn() {
        this.showPlayerTurn();
        int column = ((RandomPlayer) this.player).getColumn();
        MessageManager.getInstance().writeln("SHOW_RANDOM_COLUMN", String.valueOf(column + 1));
        return column;
    }
}
