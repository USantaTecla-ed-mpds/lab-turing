package connect4.views;

import connect4.models.MinMaxPlayer;
import connect4.utils.exceptions.MessageNotFoundException;

public class MinMaxPlayerView extends MachinePlayerView {

    public MinMaxPlayerView(MinMaxPlayer player) {
        super(player);
    }

    @Override
    public void showColumnSelected(int column) throws MessageNotFoundException {
        MessageManager.getInstance().writeln("SHOW_MINMAX_COLUMN", column);
    }
}