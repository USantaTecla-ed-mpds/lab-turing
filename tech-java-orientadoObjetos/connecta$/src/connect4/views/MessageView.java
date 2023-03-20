package connect4.views;

import java.text.MessageFormat;
import connect4.models.Message;
import connect4.utils.Console;

public class MessageView {

    private static MessageView instance;

    private MessageView() {
    }

    public static MessageView getInstance() {
        if (MessageView.instance == null) {
            MessageView.instance = new MessageView();
        }

        return MessageView.instance;
    }

    public void writelnFormated(Message message, Object... values) {
        String formattedMessage = MessageFormat.format(message.toString(), values);
        Console.getInstance().writeln(formattedMessage);
    }

    public void writeFormated(Message message, Object... values) {
        String formattedMessage = MessageFormat.format(message.toString(), values);
        Console.getInstance().write(formattedMessage);
    }

    public void writeln(Message message) {
        Console.getInstance().writeln(message.toString());
    }

    public void write(Message message) {
        Console.getInstance().write(message.toString());
    }

}
