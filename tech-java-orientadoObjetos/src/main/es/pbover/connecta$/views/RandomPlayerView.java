package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.models.RandomPlayer;
import main.es.pbover.connecta$.models.Message;

public class RandomPlayerView extends PlayerView {

    public RandomPlayerView(RandomPlayer player) {
        super(player);
    }

    public int getColumn() {
        super.showPlayerTurn();
        int column = ((RandomPlayer) this.player).getColumn();
        MessageView.getInstance().writelnFormated(Message.SHOW_RANDOM_COLUMN, String.valueOf(column + 1));
        return column;
    }
}
