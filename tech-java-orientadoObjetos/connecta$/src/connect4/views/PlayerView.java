package connect4.views;

import connect4.models.Message;
import connect4.models.Player;

public abstract class PlayerView {
    protected Player player;
    protected final MessageView messageView = new MessageView();

    public PlayerView(Player player) {
        this.player = player;
    }

    public void writeWinner() {
        messageView.writelnFormated(Message.PLAYER_WIN, this.player.getColor().getString());
    }

    public abstract int getColumn();

    public Player getPlayer() {
        return this.player;
    }

}
