package connect4.views;

import connect4.models.Board;
import connect4.models.Coordinate;
import connect4.models.Message;

public class BoardView {
    static int BLANK_SPACES = 4;
    private final Board board;
    private final MessageView messageView = new MessageView();

    public BoardView(final Board board) {
        this.board = board;
    }

    public void writeln() {
        this.writeHorizontal();
        for (int i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            new MessageView().write(Message.VERTICAL_LINE_SYMBOL);

            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                new ColorView(this.board.getColor(new Coordinate(i, j))).write();
                messageView.write(Message.VERTICAL_LINE_SYMBOL);
            }
            messageView.writeln(Message.BLANK);
        }
        this.writeHorizontal();
    }

    private void writeHorizontal() {
        for (int i = 0; i < BoardView.BLANK_SPACES * Coordinate.NUMBER_COLUMNS; i++) {
            messageView.write(Message.HORIZONTAL_LINE_SYMBOL);
        }
        messageView.writeln(Message.HORIZONTAL_LINE_SYMBOL);
    }

}
