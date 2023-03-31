package main.es.pbover.connect4Old.views;

import main.es.pbover.connect4Old.models.Color;

public class ColorView {
    private Color color;

    public ColorView(Color color) {
        this.color = color;
    }
    public void write() {
        new Message(" "+String.valueOf(this.color.getCode())+" ").write();
    }
    public String toString() {
        return this.color.getString();
    }
}
