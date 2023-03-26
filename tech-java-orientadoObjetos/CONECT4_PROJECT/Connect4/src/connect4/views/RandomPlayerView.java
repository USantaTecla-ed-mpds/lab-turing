package connect4.views;

import connect4.models.RandomPlayer;
import connect4.utils.exceptions.MessageNotFoundException;

public class RandomPlayerView extends PlayerView {

    public RandomPlayerView(RandomPlayer player) {
        super(player);
    }

    public int getColumn() throws MessageNotFoundException {
        super.showPlayerTurn();
        int column = ((RandomPlayer) this.player).getColumn();
        MessageManager.getInstance().writeln("SHOW_RANDOM_COLUMN", String.valueOf(column + 1));
        return column;
    }
}
