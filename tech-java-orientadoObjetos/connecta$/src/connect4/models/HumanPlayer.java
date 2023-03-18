package connect4.models;

public class HumanPlayer extends Player {
    public HumanPlayer(Color color, Board board) {
        super(color, board);
    }

    public void accept(PlayerVisitor visitor) {
        visitor.visit(this);
    }

}
