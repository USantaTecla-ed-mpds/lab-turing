package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.models.Color;
import main.es.pbover.connecta$.models.Message;

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
