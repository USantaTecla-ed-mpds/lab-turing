package connect4.views;

import connect4.models.Message;
import connect4.models.MinMaxPlayer;

public class MinMaxPlayerView extends PlayerView {

    public MinMaxPlayerView(MinMaxPlayer player) {
        super(player);
    }

    public int getColumn() {
        messageView.writelnFormated(Message.TURN, this.getPlayer().getColor().getString());
        int column = ((MinMaxPlayer) this.player).getColumn();
        messageView.writelnFormated(Message.SHOW_MINMAX_COLUMN, String.valueOf(column + 1));
        // Message.MINMAX_COLUMN.writelnFormated(String.valueOf(column + 1));
        return column;
    }
}