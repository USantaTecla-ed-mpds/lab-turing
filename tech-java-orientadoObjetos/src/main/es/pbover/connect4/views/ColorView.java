package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.Color;
import main.es.pbover.connect4.models.Message;

public class ColorView {
    private final Color color;

    public ColorView(final Color color) {
        this.color = color;

    }

    public void write() {
        MessageView.getInstance().writeFormated(
                Message.PLAYER_COLOR,
                String.valueOf(this.color.getCode()));
    }

    public String toString() {
        return this.color.getString();
    }
}
