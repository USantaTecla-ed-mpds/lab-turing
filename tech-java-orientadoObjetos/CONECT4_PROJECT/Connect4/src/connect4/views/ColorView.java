package connect4.views;

import connect4.models.Color;
import connect4.utils.MessageManager;

public class ColorView {
    private final Color color;

    public ColorView(final Color color) {
        this.color = color;

    }

    public void write() {
        MessageManager.getInstance().write(
                "PLAYER_COLOR",
                String.valueOf(this.color.getCode()));
    }

    public String toString() {
        return this.color.getString();
    }
}
