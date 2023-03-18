package connect4.views;

import connect4.models.Color;
import connect4.models.Message;

public class ColorView {
    private Color color;

    public ColorView(Color color) {
        this.color = color;
    }

    public void write() {
        Message.PLAYER_COLOR.writeFormated(String.valueOf(this.color.getCode()));
    }

    public String toString() {
        return this.color.getString();
    }
}
