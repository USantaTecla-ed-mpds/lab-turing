package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.PlayerType;

public class HumanPlayer extends Player {
    public HumanPlayer(Board board) {
        super(board);

    }

    public HumanPlayer clone() {
        HumanPlayer clone = new HumanPlayer (this.board);
        clone.setColor(this.getColor());
        return clone;
    }

    public PlayerType getType() {
        return PlayerType.HUMAN;
    }

}
