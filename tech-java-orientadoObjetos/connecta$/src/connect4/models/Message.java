package connect4.models;

import java.text.MessageFormat;

public enum Message {
    BLANK(" "),
    GAME_TITLE("--- CONNECT 4 ---"),
    ASK_NUM_PLAYERS("Enter number of human players"),
    ERR_NUM_PLAYERS("The value must be between {0} and {1}"),
    PLAYER_COLOR(" {0} "),
    SUFIX("? [{0}-{1}]: "),
    HORIZONTAL_LINE_SYMBOL("-"),
    VERTICAL_LINE_SYMBOL("|"),
    TURN("Turn: {0}"),
    ASK_COLUMN_TO_DROP("Enter a column to drop a token: "),
    ERR_INVALID_COLUMN_TO_DROP("Invalid columnn!!! Values [{0}-{1}]"),
    ERR_COMPLETED_COLUMN_TO_DROP("Invalid column!!! It's completed"),
    SHOW_RANDOM_COLUMN("Choosed Random column: {0}"),
    SHOW_MINMAX_COLUMN("Choosed MinMax column: {0}"),
    PLAYER_WIN("{0} WIN!!!"),
    PLAYERS_TIED("TIED!!!"),
    RESUME("Do you want to continue"),
    ASK_MACHINE_TYPE("Enter Random (1) or IA Machine Player (2) for Player {0}: ");

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public String getFormatedMessage(Object... values) {
        String formattedMessage = MessageFormat.format(this.message, values);
        return formattedMessage;
    }

    public String toString() {
        return this.message.toString();
    }
}