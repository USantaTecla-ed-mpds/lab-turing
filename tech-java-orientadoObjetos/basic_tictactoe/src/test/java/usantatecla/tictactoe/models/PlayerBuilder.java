package usantatecla.tictactoe.models;

import java.util.List;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

public class PlayerBuilder {

    private Color color;
    private String[] rows;
    private Player player;

    public PlayerBuilder() {
        this.rows = new String[]{
                "   ",
                "   ",
                "   "};
    }

    public PlayerBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public PlayerBuilder rows(String... rows) {
        this.rows = rows;
        return this;
    }

    public Player build() {
        Board board = new BoardBuilder().build();
        this.player = new Player(this.color, board);
        this.putTokens();
        return this.player;
    }

    private void putTokens() {
        Board board = new BoardBuilder().rows(this.rows).build();
        List<Coordinate> coordinates = board.getCoordinates(this.color);
        while (coordinates.size() > 0) {
            Coordinate coordinate = coordinates.remove(0);
            this.player.putToken(coordinate);
        }
    }
    
}
