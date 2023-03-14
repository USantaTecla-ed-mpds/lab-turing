package usantatecla.tictactoe.types;

import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.SquareBoundedCoordinate;

public class Coordinate extends SquareBoundedCoordinate {

    public static final int DIMENSION = 3;

    public Coordinate() {
        super();
    }

    public Coordinate(int row, int column) {
        super(row, column);
    }

    public Coordinate(ConcreteCoordinate concreteCoordinate) {
        super(concreteCoordinate);
    }

    @Override
    protected int getDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (!other.isNull()) {
            if (this.getRow() != other.getRow())
                return false;
            if (this.getColumn() != other.getColumn())
                return false;
        }
        return true;
    }

}
