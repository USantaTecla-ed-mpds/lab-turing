package es.usantatecla.tictactoe_v2.main.models;

import es.usantatecla.tictactoe_v2.utils.Direction;

public class Board {

	private Color[][] colors;

	public Board() {
		this.colors = new Color[BoundedCoordinate.getDimension()][BoundedCoordinate.getDimension()];
		this.reset();
	}

	public void reset() {
		for (int i = 0; i < BoundedCoordinate.getDimension(); i++) {
			for (int j = 0; j < BoundedCoordinate.getDimension(); j++) {
				this.colors[i][j] = Color.NULL;
			}
		}
	}

	public boolean isComplete(Color color) {
		for (BoundedCoordinate boundedCoordinate : this.getCoordinates(color)) {
			if (boundedCoordinate == null) {
				return false;
			}
		}
		return true;
	}

	private BoundedCoordinate[] getCoordinates(Color color) {
		assert !color.isNull();

		BoundedCoordinate[] boundedCoordinates = new BoundedCoordinate[BoundedCoordinate.getDimension()];
		int k = 0;
		for (int i = 0; i < BoundedCoordinate.getDimension(); i++) {
			for (int j = 0; j < BoundedCoordinate.getDimension(); j++) {
				if (this.getColor(new BoundedCoordinate(i, j)) == color) {
					boundedCoordinates[k] = new BoundedCoordinate(i, j);
					k++;
				}
			}
		}
		return boundedCoordinates;
	}

	public void putToken(BoundedCoordinate boundedCoordinate, Color color) {
		assert boundedCoordinate != null;

		this.colors[boundedCoordinate.getRow()][boundedCoordinate.getColumn()] = color;
	}

	public void moveToken(BoundedCoordinate origin, BoundedCoordinate target) {
		assert origin != null && !this.isEmpty(origin);
		assert target != null && this.isEmpty(target);
		assert !origin.equals(target);

		Color color = this.getColor(origin);
		this.putToken(origin, Color.NULL);
		this.putToken(target, color);
	}

	public Color getColor(BoundedCoordinate boundedCoordinate) {
		assert boundedCoordinate != null;

		return this.colors[boundedCoordinate.getRow()][boundedCoordinate.getColumn()];
	}

	public boolean isOccupied(BoundedCoordinate boundedCoordinate, Color color) {
		return this.getColor(boundedCoordinate) == color;
	}

	public boolean isEmpty(BoundedCoordinate boundedCoordinate) {
		return this.isOccupied(boundedCoordinate, Color.NULL);
	}

	public boolean isTicTacToe(Color color) {
		assert !color.isNull();

		Direction[] directions = this.getDirections(color);
		if (directions.length < BoundedCoordinate.getDimension() - 1) {
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

		BoundedCoordinate[] boundedCoordinates = this.getCoordinates(color);
		int pairs = 0;
		for (int i = 1; i < boundedCoordinates.length; i++) {
			if (boundedCoordinates[i] != null) {
				pairs++;
			}
		}
		Direction[] directions = new Direction[pairs];
		for (int i = 0; i < directions.length; i++) {
			directions[i] = boundedCoordinates[i].getDirection(boundedCoordinates[i + 1]);
		}
		return directions;
	}

}
