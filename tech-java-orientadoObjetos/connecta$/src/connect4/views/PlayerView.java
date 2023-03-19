package connect4.views;

import connect4.models.Message;
import connect4.models.Player;

public abstract class PlayerView {
    protected Player player;

    public PlayerView(Player player) {
        this.player = player;
    }

    public void writeWinner() {
        Message.PLAYER_WIN.writelnFormated(this.player.getColor().getString());
    }

    public abstract int getColumn();

    public Player getPlayer() {
        return this.player;
    }

}
