package connect4.views;

import connect4.models.Message;
import connect4.models.RandomPlayer;

public class RandomPlayerView extends PlayerView {

    public RandomPlayerView(RandomPlayer player) {
        super(player);
    }

    public int getColumn() {
        messageView.writelnFormated(Message.TURN, this.getPlayer().getColor().name());
        int column = ((RandomPlayer) this.player).getColumn();
        messageView.writelnFormated(Message.SHOW_RANDOM_COLUMN, String.valueOf(column + 1));
        return column;
    }
}
