package connect4.views;

import connect4.models.Player;
import connect4.utils.MessageManager;

public abstract class PlayerView {
    protected Player player;

    public PlayerView(Player player) {
        this.player = player;

    }

    protected void showWinner() {
        MessageManager.getInstance().writeln("PLAYER_WIN", this.player.getColor().getString());
    }

    protected void showPlayerTurn() {
        MessageManager.getInstance().writeln("TURN", this.getPlayer().getColor().getString());
    }

    public abstract int getColumn();

    public Player getPlayer() {
        return this.player;
    }

}
