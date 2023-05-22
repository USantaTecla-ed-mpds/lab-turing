package main.es.labturing.connect4.models;

import java.io.Serializable;

import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.types.PlayerType;

public abstract class Player implements Serializable{
    private Color color;
    protected Board board;

    public Player(Board board) {
        this.board = board;
    }

    public void dropToken(int column) {
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

    public abstract PlayerType getType();
}
