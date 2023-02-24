package es.usantatecla.tictactoe_v2.main.models;

public class Player {

	private Color color;
	private Board board;

	public Player(Color color, Board board) {
		assert !color.isNull();
		assert board != null;

		this.color = color;
		this.board = board;
	}

	public void putToken(BoundedCoordinate boundedCoordinate) {
		this.board.putToken(boundedCoordinate, this.color);
	}

	public Error getPutTokenError(BoundedCoordinate boundedCoordinate) {
		assert boundedCoordinate != null;

		Error error = Error.NULL;
		if (!this.board.isEmpty(boundedCoordinate)) {
			error = Error.NOT_EMPTY;
		}
		return error;
	}

	public void moveToken(BoundedCoordinate origin, BoundedCoordinate target) {
		this.board.moveToken(origin, target);
	}

	public Error getOriginMoveTokenError(BoundedCoordinate origin) {
		assert origin != null;

		Error error = Error.NULL;
		if (!this.board.isOccupied(origin, this.color)) {
			error = Error.NOT_OWNER;
		}
		return error;
	}

	public Error getTargetMoveTokenError(BoundedCoordinate origin, BoundedCoordinate target) {
		assert origin != null;
		assert target != null;

		Error error = Error.NULL;
		if (origin.equals(target)) {
			error = Error.SAME_COORDINATES;
		} else if (!this.board.isEmpty(target)) {
			error = Error.NOT_EMPTY;
		}
		return error;
	}

	public Color getColor() {
		return this.color;
	}

	public Board getBoard() {
		return this.board;
	}

}
