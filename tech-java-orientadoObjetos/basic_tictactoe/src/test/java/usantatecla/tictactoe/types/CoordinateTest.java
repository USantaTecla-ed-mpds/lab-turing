package usantatecla.tictactoe.types;

import usantatecla.utils.models.SquareBoundedCoordinate;
import usantatecla.utils.models.SquareBoundedCoordinateTest;

public class CoordinateTest extends SquareBoundedCoordinateTest {

    @Override
    public SquareBoundedCoordinate getNullCoordinate() {
        return new Coordinate();
    }

    @Override
    public int getDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    public SquareBoundedCoordinate getCoordinate(int row, int column) {
        return new Coordinate(row, column);
    }

}
