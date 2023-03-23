package connect4.models;

public class HumanPlayer extends Player {
    public HumanPlayer(Board board) {
        super(board);
    }

    public void accept(PlayerVisitor visitor) {
        visitor.visit(this);
    }

}
