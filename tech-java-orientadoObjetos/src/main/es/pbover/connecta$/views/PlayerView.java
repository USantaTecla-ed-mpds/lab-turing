package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.models.Player;
import main.es.pbover.connecta$.models.Message;

public abstract class PlayerView {
    protected Player player;

    public PlayerView(Player player) {
        this.player = player;

    }

    protected void showWinner() {
        MessageView.getInstance().writelnFormated(Message.PLAYER_WIN, this.player.getColor().getString());
    }

    protected void showPlayerTurn() {
        MessageView.getInstance().writelnFormated(Message.TURN, this.getPlayer().getColor().getString());
    }

    public abstract int getColumn();

    public Player getPlayer() {
        return this.player;
    }

}
