package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.models.MinMaxPlayer;
import main.es.pbover.connecta$.models.Message;

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