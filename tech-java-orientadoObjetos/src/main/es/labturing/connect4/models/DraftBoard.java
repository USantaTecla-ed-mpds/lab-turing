package main.es.labturing.connect4.models;

public class DraftBoard extends Board {

    public DraftBoard(Board board) {
        this.colors = board.getColors().clone();
        this.lastDrop = board.getLastDrop();
    }

    public boolean isAlmostWinner() {
        if (this.lastDrop == null) {
            return false;
        }
        for (Direction direction : Direction.halfValues()) {
            Line line = new Line(this.lastDrop, direction, DraftBoard.LINE_LENGTH - 1);
            for (int i = 0; i < DraftBoard.LINE_LENGTH - 1; i++) {
                if (this.isConnect3(line)) {
                    return true;
                }
                line.shift();
            }
        }
        return false;
    }

    private boolean isConnect3(Line line) {
        for (int i = 0; i < DraftBoard.LINE_LENGTH - 1; i++) {
            if (!line.getCoordinate(i).isValid()) {
                return false;
            }
            if (i > 0 && this.getColor(line.getCoordinate(i - 1)) != this.getColor(line.getCoordinate(i))) {
                return false;
            }
        }
        return true;
    }

    public void removeTop(int column) {
        this.setColor(this.getTop(column), Color.NULL);
    }

    private Coordinate getTop(int column) {
        Coordinate coordinate = new Coordinate(Coordinate.NUMBER_ROWS - 1, column);
        while (this.isEmptyPosition(coordinate)) {
            coordinate = Direction.SOUTH.next(coordinate);
        }
        return coordinate;
    }

    private void setColor(Coordinate coordinate, Color color) {
        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    public int[] getUncompletedColumns() {
        int counter = 0;
        for (int i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
            if (!this.isCompleteColumn(i)) {
                counter++;
            }
        }
        int[] uncompletedColumns = new int[counter];
        counter = 0;
        for (int i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
            if (!this.isCompleteColumn(i)) {
                uncompletedColumns[counter] = i;
                counter++;
            }
        }
        return uncompletedColumns;
    }

}
