package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.Color;

public class ColorView {
    private final Color color;

    public ColorView(Color color) {
        this.color = color;

    }

    public char getCode() {
        if (this.color == Color.NULL) {
            return ' ';
        }
        return MessageManager.getInstance().getMessage(this.color.name()).charAt(0);
    }

    public void write() {
        MessageManager.getInstance().write("PLAYER_COLOR", this.getCode());
    }

    public String toString() {
        return MessageManager.getInstance().getMessage(this.color.name());
    }

}
