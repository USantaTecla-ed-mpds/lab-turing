package connect4.models;

public abstract class Player {
    private Color color;
    private Board board;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    public void play(int column) {
        this.board.dropToken(column, this.color);
    }

    public Color getColor() {
        return this.color;
    }

    public boolean isComplete(int column) {
        return this.board.isCompleteColumn(column);
    }

    public Board getBoard() {
        return this.board;
    }

    public abstract void accept(PlayerVisitor visitor);
}
