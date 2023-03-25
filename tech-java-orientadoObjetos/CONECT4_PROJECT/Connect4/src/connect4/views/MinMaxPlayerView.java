package connect4.views;

import connect4.models.MinMaxPlayer;
import connect4.utils.MessageManager;
import connect4.utils.exceptions.MessageNotFoundException;

public class MinMaxPlayerView extends PlayerView {

    public MinMaxPlayerView(MinMaxPlayer player) {
        super(player);
    }

    public int getColumn() throws MessageNotFoundException {
        super.showPlayerTurn();
        int column = ((MinMaxPlayer) this.player).getColumn();
        MessageManager.getInstance().writeln("SHOW_MINMAX_COLUMN", String.valueOf(column + 1));
        return column;
    }
}