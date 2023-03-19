package connect4.views;

import connect4.models.Color;
import connect4.models.Message;

public class ColorView {
    private final Color color;
    private final MessageView messageView;

    public ColorView(final Color color) {
        this.color = color;
        this.messageView = new MessageView();
    }

    public void write() {
        this.messageView.writeFormated(Message.PLAYER_COLOR, String.valueOf(this.color.getCode()));
    }

    public String toString() {
        return this.color.getString();
    }
}
