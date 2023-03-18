package connect4.models;

import java.text.MessageFormat;
import connect4.utils.Console;

public enum Message {
    BLANK(" "),
    TITLE("--- CONNECT 4 ---"),
    NUM_PLAYERS("Enter number of human players"),
    PLAYER_COLOR(" {0} "),
    SUFIX("? [{0}-{1}]: "),
    INVALID_NUM_PLAYERS("The value must be between {0} and {1}"),
    HORIZONTAL_LINE("-"),
    VERTICAL_LINE("|"),
    TURN("Turn: {0}"),
    ENTER_COLUMN_TO_DROP("Enter a column to drop a token: "),
    INVALID_COLUMN("Invalid columnn!!! Values [{0}-{1}]"),
    COMPLETED_COLUMN("Invalid column!!! It's completed"),
    RANDOM_COLUMN("Choosed radom column: "),
    PLAYER_WIN("WIN!!!"),
    PLAYERS_TIED("TIED!!!"),
    RESUME("Do you want to continue"),
    TYPE_MACHINE("Enter Random (1) or IA Machine Player (2) for Player {0}: ");

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public String getFormated(String... values) {
        String formattedMessage = MessageFormat.format(this.message, values);
        return formattedMessage;
    }

    public void writelnFormated(String... values) {
        String formattedMessage = MessageFormat.format(this.message, values);
        Console.getInstance().writeln(formattedMessage);
    }

    public void writeFormated(String... values) {
        String formattedMessage = MessageFormat.format(this.message, values);
        Console.getInstance().write(formattedMessage);
    }

    public void writeln() {
        Console.getInstance().writeln(this.message);
    }

    public void write() {
        Console.getInstance().write(this.message);
    }

    public String toString() {
        return this.message;
    }
}