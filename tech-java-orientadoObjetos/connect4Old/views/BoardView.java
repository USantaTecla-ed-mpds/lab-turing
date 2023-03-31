package views;

import models.Board;
import models.Coordinate;

public class BoardView {
    static int BLANK_SPACES = 4;
    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }
    public void writeln() {
        this.writeHorizontal();
        for (int i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                new ColorView(this.board.getColor(new Coordinate(i, j))).write();
                Message.VERTICAL_LINE.write();
            }
            new Message("").writeln();
        }
        this.writeHorizontal();
    }

    private void writeHorizontal() {

        for (int i = 0; i < BoardView.BLANK_SPACES * Coordinate.NUMBER_COLUMNS; i++) {
            Message.HORIZONTAL_LINE.write();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

}
