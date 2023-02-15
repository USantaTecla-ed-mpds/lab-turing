package es.usantatecla.tictactoe.src.main.java.es.usantatecla.tictactoe;

public class Square {

    private Coordinate coordinate;
    private Color color;

    public Square(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.color = Color.NULL;
    }

    public Square() {
        this(new Coordinate());
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Color getColor() {
        return color;
    }
   

}
