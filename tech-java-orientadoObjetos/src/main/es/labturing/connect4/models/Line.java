package main.es.labturing.connect4.models;

public class Line {

    private int length;
    private Coordinate[] coordinates;
    private Direction direction;

    public Line(Coordinate coordinate, Direction direction, int length) {
        this.length = length;
        this.direction = direction;
        for (int i = 1; i < this.length; i++) {
            coordinates[i] = coordinates[i - 1].shifted(this.direction.getCoordinate());
        }
    }

    public void shift(Direction direction) {
        Direction oppositeDirection = direction.getOpposite();
        for (int i = 0; i < Board.LINE_LENGTH; i++) {
            coordinates[i] = coordinates[i].shifted(oppositeDirection.getCoordinate());
        }
    }

    public Coordinate getCoordinate(int i) {
        return this.coordinates[i];
    }

}
