package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Error;
import usantatecla.utils.views.Console;

class ErrorView {

    static final String[] MESSAGES = {
            "The square is not empty",
            "There is not a token of yours",
            "The origin and target squares are the same",
            "The coordinates are wrong"
    };

    void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
