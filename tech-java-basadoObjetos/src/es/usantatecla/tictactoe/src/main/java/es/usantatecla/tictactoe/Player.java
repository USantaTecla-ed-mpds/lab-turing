package es.usantatecla.tictactoe.src.main.java.es.usantatecla.tictactoe;


class Player {

	private Color color;
	private Board board;

	public Player(Color color, Board board) {
		assert !color.isNull();
		assert board != null;

		this.color = color;
		this.board = board;
	}

	public void play() {
		if (!this.board.isComplete(color)) {
			this.putToken();
		} else {
			this.moveToken();
		}
	}

	private void putToken() {
		Message.TURN.writeln(this.color.name());
		Coordinate coordinate;
		Error error;
		do {
			coordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
			error = this.getPutTokenError(coordinate);
		} while (!error.isNull());
		this.board.putToken(coordinate, this.color);
	}

	private Coordinate getCoordinate(Message message) {
		assert message != null;

		Coordinate coordinate = new Coordinate();
		coordinate.read(message.toString());
		return coordinate;
	}

	private Error getPutTokenError(Coordinate coordinate) {
		assert coordinate != null;

		Error error = Error.NULL;
		if (!this.board.isEmpty(coordinate)) {
			error = Error.NOT_EMPTY;
		}
		error.writeln();
		return error;
	}

	private void moveToken() {
		Message.TURN.writeln(this.color.name());
		Coordinate origin;
		Error error;
		do {
			origin = this.getCoordinate(Message.COORDINATE_TO_REMOVE);
			error = this.getOriginMoveTokenError(origin);
		} while (error != Error.NULL);
		Coordinate target;
		do {
			target = this.getCoordinate(Message.COORDINATE_TO_MOVE);
			error = this.getTargetMoveTokenError(origin, target);
		} while (error != Error.NULL);
		this.board.moveToken(origin, target);
	}

	private Error getOriginMoveTokenError(Coordinate origin) {
		assert origin != null;

		Error error = Error.NULL;
		if (!this.board.isOccupied(origin, this.color)) {
			error = Error.NOT_OWNER;
		}
		error.writeln();
		return error;
	}

	private Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
		assert origin != null;
		assert target != null;

		Error error = Error.NULL;
		if (origin.equals(target)) {
			error = Error.SAME_COORDINATES;
		} else if (!this.board.isEmpty(target)) {
			error = Error.NOT_EMPTY;
		}
		error.writeln();
		return error;
	}

	public void writeWinner() {
		Message.PLAYER_WIN.writeln(this.color.name());
	}

	public Color getColor() {
		return this.color;
	}

}
