package es.usantatecla.tictactoe.src.main.java.es.usantatecla.tictactoe;


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
