package es.usantatecla.tictactoe_v2.main.models;

import es.usantatecla.tictactoe_v2.utils.BoundedIntDialog;
import es.usantatecla.tictactoe_v2.utils.Console;
import es.usantatecla.tictactoe_v2.utils.Coordinate;
import es.usantatecla.tictactoe_v2.utils.Direction;

public class BoundedCoordinate {

	private Coordinate coordinate;
	private static final int DIMENSION = 3;

	public BoundedCoordinate() {
		this.coordinate = new Coordinate();
	}

	public BoundedCoordinate(int row, int column) {
		this.coordinate = new Coordinate(row, column);
	}

	public static int getDimension() {
		return BoundedCoordinate.DIMENSION;
	}

	public void read(String title) {
		BoundedIntDialog boundedIntDialog = new BoundedIntDialog(1, BoundedCoordinate.getDimension());
		new Console().writeln(title);
		this.coordinate.setRow(boundedIntDialog.read(Message.ROW.toString()) - 1);
		this.coordinate.setColumn(boundedIntDialog.read(Message.COLUMN.toString()) - 1);

	}

	public String getErrorMessage() {
		return Error.WRONG_COORDINATES.toString();
	}

	public Direction getDirection(Coordinate coordinate) {
		return this.coordinate.getDirection(coordinate);
	}

	public int getRow() {
		return this.coordinate.getRow();
	}

	public int getColumn() {
		return this.coordinate.getColumn();
	}
}
