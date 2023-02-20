package es.usantatecla.tictactoe_v2.utils;


enum Direction {

	VERTICAL,
	HORIZONTAL,
	MAIN_DIAGONAL,
	INVERSE_DIAGONAL,
	NULL;

	public boolean isNull() {
		return this == Direction.NULL;
	}

}
