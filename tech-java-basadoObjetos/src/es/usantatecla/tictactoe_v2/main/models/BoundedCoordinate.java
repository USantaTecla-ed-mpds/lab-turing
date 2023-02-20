package es.usantatecla.tictactoe_v2.main.models;

import es.usantatecla.tictactoe_v2.utils.Coordinate;

public class BoundedCoordinate {

    private Coordinate coordinate;
	private static final int DIMENSION = 3;

	public static int getDimension() {
		return BoundedCoordinate.DIMENSION;
	}
    
}
