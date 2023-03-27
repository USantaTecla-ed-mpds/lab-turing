package connect4.models;

import java.io.IOException;

import connect4.utils.exceptions.MessageNotFoundException;

public class HumanPlayer extends Player {
    public HumanPlayer(Board board) {
        super(board);
    }

    public void accept(PlayerVisitor visitor) throws MessageNotFoundException, ClassNotFoundException, IOException {
        visitor.visit(this);
    }

}
