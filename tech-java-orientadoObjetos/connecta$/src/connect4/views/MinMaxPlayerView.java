package connect4.views;

import connect4.utils.Console;
import connect4.models.Message;
import connect4.models.MinMaxPlayer;

public class MinMaxPlayerView extends PlayerView {

    public MinMaxPlayerView(MinMaxPlayer player) {
        super(player);
    }

    public int getColumn() {
        Message.TURN.writelnFormated(this.getPlayer().getColor().getString());
        int column = ((MinMaxPlayer) this.player).getColumn();
        Message.RANDOM_COLUMN.writeln();
        Console.getInstance().writeln(column + 1);
        return column;
    }
}