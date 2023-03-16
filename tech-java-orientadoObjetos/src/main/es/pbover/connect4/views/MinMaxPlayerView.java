package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.MinMaxPlayer;
import main.es.pbover.utils.Console;

public class MinMaxPlayerView extends PlayerView{

    public MinMaxPlayerView(MinMaxPlayer player){
        super(player);
    }

    public int getColumn() {
        Message.TURN.write();
        new Message(new ColorView(super.player.getColor()).toString()).writeln();
        int column = ((MinMaxPlayer) this.player).getColumn();
        Message.RANDOM_COLUMN.write();
        Console.getInstance().writeln(column + 1);
        return column;
    }
}