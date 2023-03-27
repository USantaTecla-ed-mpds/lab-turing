package connect4.views;

import connect4.models.MachinePlayer;
import connect4.utils.exceptions.MessageNotFoundException;

public abstract class MachinePlayerView extends PlayerView {

    public MachinePlayerView(MachinePlayer player) {
        super(player);
    }

    public int getColumn() throws MessageNotFoundException {
        super.showPlayerTurn();
        int column = ((MachinePlayer) this.player).getColumn();
        showColumnSelected(column);
        return column;
    }

    public abstract void showColumnSelected(int column) throws MessageNotFoundException;

}
