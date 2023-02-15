package es.usantatecla.tictactoe.src.main.java.es.usantatecla.tictactoe;

class Board {

	private Color[][] colors;

	public Board() {
		this.colors = new Color[Coordinate.getDimension()][Coordinate.getDimension()];
		this.reset();
	}

	public void reset() {
		for (int i = 0; i < Coordinate.getDimension(); i++) {
			for (int j = 0; j < Coordinate.getDimension(); j++) {
				this.colors[i][j] = Color.NULL;
			}
		}
	}

  public boolean isComplete(Color color) {
		for(Coordinate coordinate : this.getCoordinates(color)) {
			if (coordinate == null){
				return false;
			}
		}
		return true;
	}
		

	private Coordinate[] getCoordinates(Color color) {
		assert !color.isNull();

		Coordinate[] coordinates = new Coordinate[Coordinate.getDimension()];
		int k = 0;
		for (int i = 0; i < Coordinate.getDimension(); i++) {
			for (int j = 0; j < Coordinate.getDimension(); j++) {
				if (this.getColor(new Coordinate(i, j)) == color) {
					coordinates[k] = new Coordinate(i, j);
					k++;
				}
			}
		}
		return coordinates;
	}

	public void putToken(Coordinate coordinate, Color color) {
		assert coordinate != null;

		this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
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

		return this.colors[coordinate.getRow()][coordinate.getColumn()];
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

		Coordinate[] coordinates = this.getCoordinates(color);
		int pairs = 0;
		for (int i = 1; i < coordinates.length; i++) {
			if (coordinates[i] != null) {
				pairs++;
			}
		}
		Direction[] directions = new Direction[pairs];
		for (int i = 0; i < directions.length; i++) {
			directions[i] = coordinates[i].getDirection(coordinates[i + 1]);
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

