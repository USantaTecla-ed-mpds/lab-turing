package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.SquareBoundedCoordinate;
import usantatecla.utils.views.SquareBoundedCoordinateView;

class CoordinateView extends SquareBoundedCoordinateView {

    @Override
    public SquareBoundedCoordinate createCoordinate(ConcreteCoordinate concreteCoordinate) {
        return new Coordinate(concreteCoordinate);
    }

    @Override
    public String getErrorMessage() {
        return ErrorView.MESSAGES[Error.WRONG_COORDINATES.ordinal()];
    }

}
