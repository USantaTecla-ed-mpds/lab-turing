package connect4.models;

public enum Direction {
    NORTH(1, 0),
    NORTH_EAST(1, 1),
    EAST(0, 1),
    SOUTH_EAST(-1, 1),
    SOUTH(-1, 0),
    SOUTH_WEST(-1, -1),
    WEST(0, -1),
    NORTH_WEST(1, -1);

    private Coordinate coordinate;

    private Direction(int row, int column) {
        this.coordinate = new Coordinate(row, column);
    }

    public Direction getOpposite() {
        for (Direction direction : Direction.values()) {
            if (direction.coordinate.shifted(this.coordinate).equals(Coordinate.ORIGIN)) {
                return direction;
            }
        }
        return null;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public static Direction[] halfValues() {
        Direction[] halfDirections = new Direction[Direction.values().length / 2];
        for (int index = 0; index < Direction.values().length / 2; index++) {
            halfDirections[index] = Direction.values()[index];
        }
        return halfDirections;
    }

    public Coordinate next(Coordinate coordinate) {
        return new Coordinate(
                this.coordinate.getRow() + coordinate.getRow(),
                this.coordinate.getColumn() + coordinate.getColumn());
    }
}
