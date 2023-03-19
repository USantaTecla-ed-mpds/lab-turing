package connect4.views;

import connect4.models.Message;
import connect4.models.MinMaxPlayer;

public class MinMaxPlayerView extends PlayerView {

    public MinMaxPlayerView(MinMaxPlayer player) {
        super(player);
    }

    public int getColumn() {
        super.showPlayerTurn();
        int column = ((MinMaxPlayer) this.player).getColumn();
        MessageView.getInstance().writelnFormated(Message.SHOW_MINMAX_COLUMN, String.valueOf(column + 1));
        return column;
    }
}