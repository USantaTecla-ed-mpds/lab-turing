package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.RandomPlayer;
import main.es.pbover.utils.Console;

public class RandomPlayerView extends PlayerView{

    public RandomPlayerView(RandomPlayer player){
        super(player);
    }

    public int getColumn() {
        Message.TURN.write();
        new Message(new ColorView(this.player.getColor()).toString()).writeln();
        int column = ((RandomPlayer) this.player).getColumn();
        Message.RANDOM_COLUMN.write();
        Console.getInstance().writeln(column + 1);
        return column;
    }
}
