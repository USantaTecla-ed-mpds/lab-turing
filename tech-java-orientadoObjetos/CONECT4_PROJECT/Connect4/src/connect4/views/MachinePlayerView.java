package connect4.views;

import connect4.models.MachinePlayer;
import connect4.utils.exceptions.MessageNotFoundException;

public abstract class MachinePlayerView extends PlayerView {

    protected MachinePlayer player;

    public MachinePlayerView(MachinePlayer player) {
        super(player);
        this.player = player;

    }

    public int getColumn() throws MessageNotFoundException {
        super.showPlayerTurn();
        int column = ((MachinePlayer) this.player).getColumn();
        showOptionSelected(column);
        return column;
    }

    public abstract void showOptionSelected(int column) throws MessageNotFoundException;

}
