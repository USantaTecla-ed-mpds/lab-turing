package connect4.views;

import connect4.models.Board;
import connect4.models.Coordinate;
import connect4.models.Message;

public class BoardView {
    static int BLANK_SPACES = 4;
    private final Board board;
    private final MessageView messageView;

    public BoardView(final Board board) {
        this.board = board;
        this.messageView = new MessageView();
    }

    public void paintBoard() {
        this.writeHorizontal();
        for (int i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            this.messageView.write(Message.VERTICAL_LINE_SYMBOL);

            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                new ColorView(this.board.getColor(new Coordinate(i, j))).write();
                this.messageView.write(Message.VERTICAL_LINE_SYMBOL);
            }
            this.messageView.writeln(Message.BLANK);
        }
        this.writeHorizontal();
    }

    private void writeHorizontal() {
        for (int i = 0; i < BoardView.BLANK_SPACES * Coordinate.NUMBER_COLUMNS; i++) {
            this.messageView.write(Message.HORIZONTAL_LINE_SYMBOL);
        }
        this.messageView.writeln(Message.HORIZONTAL_LINE_SYMBOL);
    }

}
