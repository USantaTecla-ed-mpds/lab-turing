package connect4.views;

import connect4.models.Message;
import connect4.models.RandomPlayer;

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
