package es.usantatecla.tictactoe_v2.utils;

public class Coordinate {

	private int row;
	private int column;

	public Coordinate() {
	}

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public boolean inRow(Coordinate coordinate) {
		if (coordinate == null) {
			return false;
		}
		return this.row == coordinate.row;
	}

	public boolean inColumn(Coordinate coordinate) {
		if (coordinate == null) {
			return false;
		}
		return this.column == coordinate.column;
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
