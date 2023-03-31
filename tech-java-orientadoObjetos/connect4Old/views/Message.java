package views;

import utils.Console;

public class Message {
    public static Message TITLE = new Message("--- CONNECT 4 ---");
    static Message NUM_PLAYERS = new Message("Enter number of human players: ");
    static Message TYPE_MACHINE = new Message("Enter Random (1) or IA Machine Player (2): ");
    static Message HORIZONTAL_LINE = new Message("-");
    static Message VERTICAL_LINE = new Message("|");
    static Message TURN = new Message("Turn: ");
    static Message ENTER_COLUMN_TO_DROP = new Message("Enter a column to drop a token: ");
    static Message INVALID_COLUMN = new Message("Invalid columnn!!! Values [1-7]");
    static Message COMPLETED_COLUMN = new Message("Invalid column!!! It's completed");
    static Message RANDOM_COLUMN = new Message("Choosed radom column: ");
    static Message IA_COLUMN = new Message("Choosed IA column: ");
    static Message PLAYER_WIN = new Message("S WIN!!! : -)");
    static Message PLAYERS_TIED = new Message("TIED!!!");
    public static Message RESUME = new Message("Do you want to continue");

    private String string;

    public Message(String string) {
        this.string = string;
    }

    public void write() {
        Console.getInstance().write(this.string);
    }

    public void writeln() {
        Console.getInstance().writeln(this.string);
    }

    public String toString() {
        return this.string;
    }

}