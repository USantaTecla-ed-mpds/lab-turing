package es.usantatecla.tictactoe_v2.main.models;

public enum Error {

	NOT_EMPTY("The square is not empty"),
	NOT_OWNER("There is not a token of yours"),
	SAME_COORDINATES("The origin and target squares are the same"),
	WRONG_COORDINATES("The coordinates are wrong"),
	NULL;

	private String message;

	private Error() {
	}

	private Error(String message) {
		assert message != null;

		this.message = message;
	}

	public boolean isNull() {
		return this == Error.NULL;
	}

	public String getMessage() {
		return message;
	}

}
