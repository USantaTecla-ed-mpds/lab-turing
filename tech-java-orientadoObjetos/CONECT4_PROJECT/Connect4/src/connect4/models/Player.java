package connect4.models;

import java.io.IOException;
import java.io.Serializable;

import connect4.utils.exceptions.MessageNotFoundException;

public abstract class Player implements Serializable {
    private Color color;
    private Board board;

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

    public abstract void accept(PlayerVisitor visitor) throws MessageNotFoundException, ClassNotFoundException, IOException;
}
