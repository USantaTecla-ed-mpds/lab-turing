package connect4.views;

import connect4.models.Message;
import connect4.models.Player;
import connect4.utils.Console;

public abstract class PlayerView {
    protected Player player;

    public PlayerView(Player player) {
        this.player = player;
    }

    public void writeWinner() {
        String message = new ColorView(this.player.getColor()).toString() + " " + Message.PLAYER_WIN.toString();
        Console.getInstance().writeln(message);
        // new Message(message).writeln();
    }

    public abstract int getColumn();

    public Player getPlayer() {
        return this.player;
    }

}
