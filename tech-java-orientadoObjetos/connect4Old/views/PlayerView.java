package main.es.pbover.connect4Old.views;

import main.es.pbover.connect4Old.models.Player;

public abstract class PlayerView {
    protected Player player;

    public PlayerView(Player player) {
        this.player = player;
    }

    public void writeWinner() {
        String message = new ColorView(this.player.getColor()).toString() + Message.PLAYER_WIN.toString();
        new Message(message).writeln();
    }

    public abstract int getColumn();

    public Player getPlayer() {
        return this.player;
    }

}
