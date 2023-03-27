package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.Player;

public abstract class PlayerView {
    protected Player player;

    public PlayerView(Player player) {
        this.player = player;
        this.showPlayerTurn(); 
    }

    protected void showWinner() {
        MessageManager.getInstance().writeln("PLAYER_WIN", new ColorView(this.player.getColor()).toString());
    }

    protected void showPlayerTurn() {
        MessageManager.getInstance().writeln("TURN", new ColorView(this.player.getColor()).toString());
    }

    public abstract int getColumn();

    public Player getPlayer() {
        return this.player;
    }

}
