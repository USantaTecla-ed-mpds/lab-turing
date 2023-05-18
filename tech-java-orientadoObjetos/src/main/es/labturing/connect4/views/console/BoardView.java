package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.Controller;
import main.es.labturing.connect4.models.Coordinate;

public class BoardView {
    static int BLANK_SPACES = 4;

    public BoardView() {
    }

    public void writeln(Controller controller) {
        this.writeHorizontal();
        for (int i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            MessageManager.getInstance().write("VERTICAL_LINE_SYMBOL");

            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                new ColorView(controller.getColor(new Coordinate(i, j))).write();
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

}
