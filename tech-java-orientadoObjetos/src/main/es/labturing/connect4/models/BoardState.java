package main.es.labturing.connect4.models;

import java.io.Serializable;

import main.es.labturing.connect4.types.Color;

public class BoardState implements Serializable{

    private Color[][] colors;
    private Coordinate lastDrop;

    public BoardState(Color[][] colors, Coordinate lastDrop) {
        this.colors = new Color[Coordinate.NUMBER_COLUMNS][Coordinate.NUMBER_COLUMNS];
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                this.colors[i][j] = colors[i][j];
            }
        }
        if (lastDrop != null) {
            this.lastDrop = lastDrop.clone();
        }
    }

    public Color[][] getColors() {
        return this.colors;
    }

    public Coordinate getLastDrop() {
        return this.lastDrop;
    }

    public BoardState clone() {
        return new BoardState(this.colors, this.lastDrop);
    }

}
