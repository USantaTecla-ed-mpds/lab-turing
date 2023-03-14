package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.utils.models.Direction;

import java.util.ArrayList;
import java.util.List;

class Board {

    private Color[][] colors;

    Board() {
        this.colors = new Color[Coordinate.DIMENSION][Coordinate.DIMENSION];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    void putToken(Coordinate coordinate, Color color) {
        assert !coordinate.isNull();

        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    void moveToken(Coordinate origin, Coordinate target) {
        assert !origin.isNull() && !this.isEmpty(origin);
        assert !target.isNull() && this.isEmpty(target);
        assert !origin.equals(target);

        Color color = this.getColor(origin);
        this.putToken(origin, Color.NULL);
        this.putToken(target, color);
    }

    Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();

        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }

    boolean isTicTacToe(Color color) {
        assert !color.isNull();

        List<Direction> directions = this.getDirections(color);
        if (directions.size() < Coordinate.DIMENSION - 1) {
            return false;
        }
        for (int i = 0; i < directions.size() - 1; i++) {
            if (directions.get(i) != directions.get(i + 1)) {
                return false;
            }
        }
        return !directions.get(0).isNull();
    }

    private List<Direction> getDirections(Color color) {
        assert !color.isNull();

        List<Direction> directions = new ArrayList<>();
        List<Coordinate> coordinates = this.getCoordinates(color);
        if (!coordinates.isEmpty()) {
            for (int i = 0; i < coordinates.size() - 1; i++) {
                directions.add(coordinates.get(i).getDirection(coordinates.get(i + 1)));
            }
        }
        return directions;
    }

    List<Coordinate> getCoordinates(Color color) {
        assert !color.isNull();

        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                if (this.getColor(new Coordinate(i, j)) == color) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }
        return coordinates;
    }

}
