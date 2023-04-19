package main.es.labturing.connect4.models;

public class Line {

    private int length;
    private Coordinate[] coordinates;
    private Direction direction;

    public Line(Coordinate coordinate, Direction direction, int length) {
        this.length = length;
        this.coordinates = new Coordinate[this.length];
        this.coordinates[0]=coordinate;
        this.direction = direction;
        for (int i = 1; i < this.length; i++) {
            this.coordinates[i] = this.coordinates[i - 1].shifted(this.direction.getCoordinate());
        }
    }

    public void shift() {
        Direction oppositeDirection = this.direction.getOpposite();
        for (int i = 0; i < this.length; i++) {
            this.coordinates[i] = this.coordinates[i].shifted(oppositeDirection.getCoordinate());
        }
    }

    public Coordinate getCoordinate(int i) {
        return this.coordinates[i];
    }

}
