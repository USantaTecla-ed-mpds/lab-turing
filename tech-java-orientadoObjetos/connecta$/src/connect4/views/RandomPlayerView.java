package connect4.views;

import connect4.utils.Console;
import connect4.models.Message;
import connect4.models.RandomPlayer;

public class RandomPlayerView extends PlayerView {

    public RandomPlayerView(RandomPlayer player) {
        super(player);
    }

    public int getColumn() {
        Message.TURN.writelnFormated(this.getPlayer().getColor().name());
        int column = ((RandomPlayer) this.player).getColumn();
        Message.RANDOM_COLUMN.writeln();
        Console.getInstance().writeln(column + 1);
        return column;
    }
}
