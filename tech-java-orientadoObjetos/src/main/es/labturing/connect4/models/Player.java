package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.PlayerType;

public abstract class Player {
    private Color color;
    private Board board;
    protected PlayerType type;

    public Player(Board board) {
        this.board = board;
    }

    public void play(int column) {
        this.board.dropToken(column, this.color);
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isComplete(int column) {
        return this.board.isCompleteColumn(column);
    }

    public Board getBoard() {
        return this.board;
    }

    PlayerType getType() {
        return this.type;
    }

    //public abstract void accept(PlayerVisitor visitor);
}
