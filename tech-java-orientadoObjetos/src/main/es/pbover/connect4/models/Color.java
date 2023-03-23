package main.es.pbover.connect4.models;

import main.es.pbover.connect4.views.MessageManager;

public enum Color {

    RED(MessageManager.getInstance().getMessage("RED")),
    YELLOW(MessageManager.getInstance().getMessage("YELLOW")),
    NULL(MessageManager.getInstance().getMessage("WHITE"));

    private String name;

    private Color(String name) {
        this.name = name;
    }

    public static Color get(int ordinal) {
        return Color.values()[ordinal];
    }

    public String getString() {
        return this.name;
    }

    public Color getOpposite() {
        return Color.values()[this.ordinal() % (Color.values().length - 1)];
    }

    public char getCode() {
        if (this == Color.NULL) {
            return ' ';
        }
        return this.name().charAt(0);
    }
}
