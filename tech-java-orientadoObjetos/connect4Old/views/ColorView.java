package views;

import models.Color;

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
