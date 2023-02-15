package es.usantatecla.tictactoe;

class Coordinate {

	private static final int DIMENSION = 3;
	private int row;
	private int column;

	public static int getDimension() {
		return Coordinate.DIMENSION;
	}

	public Coordinate() {
	}

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public Direction getDirection(Coordinate coordinate) {
		assert coordinate != null;

		if (this.equals(coordinate)) {
			return Direction.NULL;
		}
		if (this.inHorizontal(coordinate)) {
			return Direction.HORIZONTAL;
		}
		if (this.inVertical(coordinate)) {
			return Direction.VERTICAL;
		}
		if (this.inMainDiagonal() && coordinate.inMainDiagonal()) {
			return Direction.MAIN_DIAGONAL;
		}
		if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
			return Direction.INVERSE_DIAGONAL;
		}
		return Direction.NULL;
	}

	private boolean inHorizontal(Coordinate coordinate) {
		if (coordinate == null) {
			return false;
		}
		return this.row == coordinate.row;
	}

	private boolean inVertical(Coordinate coordinate) {
		if (coordinate == null) {
			return false;
		}
		return this.column == coordinate.column;
	}

	private boolean inMainDiagonal() {
		return this.row - this.column == 0;
	}

	private boolean inInverseDiagonal() {
		return this.row + this.column == Coordinate.DIMENSION - 1;
	}

	public void read(String title) {
		BoundedIntDialog boundedIntDialog = new BoundedIntDialog(1, Coordinate.getDimension());
		new Console().writeln(title);
    this.row = boundedIntDialog.read(Message.ROW.toString()) - 1;
		this.column = boundedIntDialog.read(Message.COLUMN.toString()) - 1;
	}

	public String getErrorMessage() {
		return Error.WRONG_COORDINATES.toString();
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public boolean equals(Coordinate coordinate) {
		if (this == coordinate)
			return true;
		if (coordinate == null)
			return false;
		if (this.column != coordinate.column)
			return false;
		if (this.row != coordinate.row)
			return false;
		return true;
	}

}
