package main.es.pbover.connect4.models;

public enum Color {

    RED,
    YELLOW,
    NULL;

    private Color() {

    }

    public static Color get(int ordinal) {
        return Color.values()[ordinal];
    }

    public Color getOpposite() {
        return Color.values()[this.ordinal() % (Color.values().length - 1)];
    }

}
