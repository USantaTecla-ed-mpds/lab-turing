package main.es.labturing.connect4.models;

public class BoardState {

    private Color[][] colors;
    private Coordinate lastDrop;

    public BoardState(Color[][] colors, Coordinate lastDrop){
        this.colors = new Color[Coordinate.NUMBER_COLUMNS][Coordinate.NUMBER_COLUMNS];
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                this.colors[i][j] = colors[i][j];
            }
        }

        this.lastDrop = lastDrop.clone();
    }

    public Color[][] getColors() {
        return this.colors;
    }

    public Coordinate getLastDrop() {
        return this.lastDrop;
    }

}
