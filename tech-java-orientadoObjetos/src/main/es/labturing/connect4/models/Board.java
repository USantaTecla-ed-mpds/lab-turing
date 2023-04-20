package main.es.labturing.connect4.models;

public class Board {

    public static final int LINE_LENGTH = 4;
    protected Color[][] colors;
    protected Coordinate lastDrop;

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
        while (!this.isEmptyPosition(this.lastDrop)) {
            this.lastDrop = this.lastDrop.shifted(Direction.NORTH.getCoordinate());
        }
        this.colors[this.lastDrop.getRow()][this.lastDrop.getColumn()] = color;
    }

    public boolean isEmptyPosition(Coordinate coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }

    private boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    private boolean isComplete() {
        for (int i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
            if (!this.isCompleteColumn(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCompleteColumn(int column) {
        return !this.isEmptyPosition(new Coordinate(Coordinate.NUMBER_ROWS - 1, column));
    }

    public boolean isGameFinished() {
        return this.isComplete() || this.isWinner();
    }

    public boolean isWinner() {
        if (this.lastDrop == null) {
            return false;
        }
        for (Direction direction : Direction.halfValues()) {
            Line line = new Line(this.lastDrop, direction, Board.LINE_LENGTH);
            for (int i = 0; i < Board.LINE_LENGTH; i++) {
                if (this.isConnect4(line)) {
                    return true;
                }
                line.shift();
            }
        }
        return false;
    }

    private boolean isConnect4(Line line) {
        for (int i = 0; i < Board.LINE_LENGTH; i++) {
            if (!line.getCoordinate(i).isValid()) {
                return false;
            }
            if (i > 0 && this.getColor(line.getCoordinate(i - 1)) != this.getColor(line.getCoordinate(i))) {
                return false;
            }
        }
        return true;
    }

    public Color getColor(Coordinate coordinate) {
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    public Color[][] getColors() {
        return this.colors;
    }

    public Coordinate getLastDrop() {
        return this.lastDrop;
    }

    public void setColors(Color[][] colors) {
        this.colors = colors;
    }

    public void setLastDrop(Coordinate lastDrop) {
        this.lastDrop = lastDrop;
    }

}
