package es.usantatecla.tictactoe.src.main.java.es.usantatecla.tictactoe;

class Board {

	private Square[][] squares;

	public Board() {
		this.squares = new Square[Coordinate.getDimension()][Coordinate.getDimension()];
		this.reset();
	}

	public void reset() {
		for (int i = 0; i < Coordinate.getDimension(); i++) {
			for (int j = 0; j < Coordinate.getDimension(); j++) {
				this.squares[i][j]= new Square(new Coordinate(i,j));
			}
		}
	}

  public boolean isComplete(Color color) {
		for(Square squares : this.getSquares(color)) {
			if (squares == null){
				return false;
			}
		}
		return true;
	}
		

	//private Coordinate[] getCoordinates(Color color) {
	private Square[] getSquares(Color color) {
		assert !color.isNull();

		Square[] squares = new Square[Coordinate.getDimension()];
		int k = 0;
		for (int i = 0; i < Coordinate.getDimension(); i++) {
			for (int j = 0; j < Coordinate.getDimension(); j++) {
				if (this.getColor(new Coordinate(i,j)) == color) {
					squares[k] = this.squares[i][j];
					k++;
				}
			}
		}
		return squares;
	}

	public void putToken(Coordinate coordinate, Color color) {
		assert coordinate != null;

		this.squares[coordinate.getRow()][coordinate.getColumn()].setColor(color);
	}

	public void moveToken(Coordinate origin, Coordinate target) {
		assert origin != null && !this.isEmpty(origin);
		assert target != null && this.isEmpty(target);
		assert !origin.equals(target);

		Color color = this.getColor(origin);
		this.putToken(origin, Color.NULL);
		this.putToken(target, color);
	}

	private Color getColor(Coordinate coordinate) {
		assert coordinate != null;

		return this.squares[coordinate.getRow()][coordinate.getColumn()].getColor();
	}

	public boolean isOccupied(Coordinate coordinate, Color color) {
		return this.getColor(coordinate) == color;
	}

	public boolean isEmpty(Coordinate coordinate) {
		return this.isOccupied(coordinate, Color.NULL);
	}

	public boolean isTicTacToe(Color color) {
		assert !color.isNull();

		Direction[] directions = this.getDirections(color);
		if (directions.length < Coordinate.getDimension() - 1) {
			return false;
		}
		for (int i = 0; i < directions.length - 1; i++) {
			if (directions[i] != directions[i + 1]) {
				return false;
			}
		}
		return !directions[0].isNull();
	}

	private Direction[] getDirections(Color color) {
		assert !color.isNull();

		Square[] squares = this.getSquares(color);
		int pairs = 0;
		for (int i = 1; i < squares.length; i++) {
			if (squares[i] != null) {
				pairs++;
			}
		}
		Direction[] directions = new Direction[pairs];
		for (int i = 0; i < directions.length; i++) {
			directions[i] = squares[i].getCoordinate().getDirection(squares[i + 1].getCoordinate());
		}
		return directions;
	}

	public void write() {
		Message.HORIZONTAL_LINE.writeln();
		for (int i = 0; i < Coordinate.getDimension(); i++) {
			Message.VERTICAL_LINE.write();
			for (int j = 0; j < Coordinate.getDimension(); j++) {
				this.getColor(new Coordinate(i, j)).write();
				Message.VERTICAL_LINE.write();
			}
			Console.getInstance().writeln();
		}
		Message.HORIZONTAL_LINE.writeln();
	}

}

