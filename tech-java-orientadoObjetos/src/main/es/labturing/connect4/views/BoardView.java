package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.Board;
import main.es.labturing.connect4.models.Coordinate;

public class BoardView {
    static int BLANK_SPACES = 4;
    private final Board board;

    public BoardView(final Board board) {
        this.board = board;
    }

    public void writeln() {
        this.writeHorizontal();
        for (int i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            MessageManager.getInstance().write("VERTICAL_LINE_SYMBOL");

            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                new ColorView(this.board.getColor(new Coordinate(i, j))).write();
                MessageManager.getInstance().write("VERTICAL_LINE_SYMBOL");
            }
            MessageManager.getInstance().writeln("BLANK");
        }
        this.writeHorizontal();
    }

    private void writeHorizontal() {
        for (int i = 0; i < BoardView.BLANK_SPACES * Coordinate.NUMBER_COLUMNS; i++) {
            MessageManager.getInstance().write("HORIZONTAL_LINE_SYMBOL");
        }
        MessageManager.getInstance().writeln("HORIZONTAL_LINE_SYMBOL");
    }

    public boolean isGameFinished() {
        return this.board.isGameFinished();
    }

}
