package models;

public class Board {

    public static final int LINE_LENGTH = 4;
    private Color[][] colors;
    private Coordinate lastDrop;

    public Board() {
        this.colors = new Color[Coordinate.NUMBER_ROWS][Coordinate.NUMBER_COLUMNS];
        this.reset();
    }

    public void reset() {
        for (int i = 0; i < Coordinate.NUMBER_ROWS; i++) {
            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    public void dropToken(int column, Color color) {
        this.lastDrop = new Coordinate(0, column);
        while (!this.isEmpty(this.lastDrop)) {
            this.lastDrop = this.lastDrop.shifted(Direction.NORTH.getCoordinate());
        }
        this.colors[this.lastDrop.getRow()][this.lastDrop.getColumn()] = color;
    }

    public boolean isEmpty() {
        for (int i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
            if (!this.isEmpty(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty(int value) {

        return this.isEmpty(new Coordinate(0, value));

    }

    public boolean isEmpty(Coordinate value) {

        return this.isOccupied(value, Color.NULL);

    }

    public boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    public boolean isComplete() {

        for (int i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
            if (!this.isComplete(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isComplete(int column) {

        return !this.isEmpty(new Coordinate(Coordinate.NUMBER_ROWS - 1, column));

    }

    public boolean isFinished() {
        return this.isComplete() || this.isWinner();
    }

    public boolean isWinner() {
        if (this.lastDrop == null) {
            return false;
        }
        for (Direction direction : Direction.halfValues()) {
            Coordinate[] line = new Coordinate[Board.LINE_LENGTH];
            line[0] = this.lastDrop;
            this.setLine(line, direction);
            for (int i = 0; i < Board.LINE_LENGTH; i++) {
                if (this.isConnect4(line)) {
                    return true;
                }
                this.shiftLine(line, direction);
            }
        }
        return false;
    }

    private void setLine(Coordinate[] line, Direction direction) {
        for (int i = 1; i < Board.LINE_LENGTH; i++) {
            line[i] = line[i - 1].shifted(direction.getCoordinate());
        }
    }

    private void shiftLine(Coordinate[] line, Direction direction) {
        Direction oppositeDirection = direction.getOpposite();
        for (int i = 0; i < Board.LINE_LENGTH; i++) {
            line[i] = line[i].shifted(oppositeDirection.getCoordinate());
        }
    }

    private boolean isConnect4(Coordinate[] line) {
        for (int i = 0; i < Board.LINE_LENGTH; i++) {
            if (!line[i].isValid()) {
                return false;
            }
            if (i > 0 && this.getColor(line[i - 1]) != this.getColor(line[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isAlmostWinner() {
        if (this.lastDrop == null) {
            return false;
        }
        for (Direction direction : Direction.halfValues()) {
            Coordinate[] line = new Coordinate[Board.LINE_LENGTH - 1];
            line[0] = this.lastDrop;
            this.set3Line(line, direction);
            for (int i = 0; i < Board.LINE_LENGTH - 1; i++) {
                if (this.isConnect3(line)) {
                    return true;
                }
                this.shift3Line(line, direction);
            }
        }
        return false;
    }

    private void set3Line(Coordinate[] line, Direction direction) {
        for (int i = 1; i < Board.LINE_LENGTH - 1; i++) {
            line[i] = line[i - 1].shifted(direction.getCoordinate());
        }
    }

    private void shift3Line(Coordinate[] line, Direction direction) {
        Direction oppositeDirection = direction.getOpposite();
        for (int i = 0; i < Board.LINE_LENGTH - 1; i++) {
            line[i] = line[i].shifted(oppositeDirection.getCoordinate());
        }
    }

    private boolean isConnect3(Coordinate[] line) {
        for (int i = 0; i < Board.LINE_LENGTH - 1; i++) {
            if (!line[i].isValid()) {
                return false;
            }
            if (i > 0 && this.getColor(line[i - 1]) != this.getColor(line[i])) {
                return false;
            }
        }
        return true;
    }

    public Color getColor(Coordinate coordinate) {
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    public void setColor(Coordinate coordinate, Color color) {
        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    public int[] getUncompletedColumns() {
        int counter = 0;
        for (int i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
            if (!this.isComplete(i)) {
                counter++;
            }
        }
        int[] uncompletedColumns = new int[counter];
        counter = 0;
        for (int i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
            if (!this.isComplete(i)) {
                uncompletedColumns[counter] = i;
                counter++;
            }
        }
        return uncompletedColumns;
    }

    public void removeTop(int column) {
        this.setColor(this.getTop(column), Color.NULL);
    }

    public Coordinate getTop(int column) {
        Coordinate coordinate = new Coordinate(Coordinate.NUMBER_ROWS - 1, column);
        while (this.isEmpty(coordinate)) {
            coordinate = Direction.SOUTH.next(coordinate);
        }
        return coordinate;
    }

}
