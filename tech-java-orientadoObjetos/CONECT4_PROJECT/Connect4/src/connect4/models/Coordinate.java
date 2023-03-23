package connect4.models;

import connect4.utils.ClosedInterval;

public class Coordinate {
    public static Coordinate ORIGIN = new Coordinate(0, 0);
    public static int NUMBER_ROWS = 6;
    private static ClosedInterval ROWS = new ClosedInterval(0, Coordinate.NUMBER_ROWS - 1);
    public static int NUMBER_COLUMNS = 7;
    private static ClosedInterval COLUMNS = new ClosedInterval(0, Coordinate.NUMBER_COLUMNS - 1);

    private int row;
    private int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinate shifted(Coordinate coordinate) {
        return new Coordinate(this.row + coordinate.row, this.column + coordinate.column);
    }

    public boolean isValid() {
        return Coordinate.isRowValid(this.getRow())
                && Coordinate.isColumnValid(this.getColumn());
    }

    public static boolean isColumnValid(int column) {
        return Coordinate.COLUMNS.isIncluded(column);
    }

    private static boolean isRowValid(int row) {
        return Coordinate.ROWS.isIncluded(row);
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public boolean equals(Coordinate coordinate) {
        if (this == coordinate)
            return true;
        if (coordinate == null)
            return false;
        return this.column == coordinate.column && this.row == coordinate.row;
    }
}
