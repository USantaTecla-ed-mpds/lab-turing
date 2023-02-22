package es.usantatecla.tictactoe_v2.main.views;

import es.usantatecla.tictactoe_v2.main.models.Message;
import es.usantatecla.tictactoe_v2.main.models.BoundedCoordinate;
import es.usantatecla.tictactoe_v2.main.models.Error;
import es.usantatecla.tictactoe_v2.main.models.Player;
import es.usantatecla.tictactoe_v2.utils.Coordinate;

class PlayerView {

	private Player player;

	public PlayerView(Player player) {
		this.player = player;
	}

	public void play() {
		if (!this.player.getBoard().isComplete(this.player.getColor())) {
			this.putToken();
		} else {
			this.moveToken();
		}
	}

	private void putToken() {
		new MessageView(Message.TURN).writeln(this.player.getColor().name());
		BoundedCoordinate boundedCoordinate;
		Error error;
		do {
			boundedCoordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
			error = this.getPutTokenError(boundedCoordinate);
		} while (!error.isNull());
		this.player.getBoard().putToken(boundedCoordinate, this.player.getColor());
	}

	private BoundedCoordinate getCoordinate(Message message) {
		assert message != null;

		BoundedCoordinate boundedCoordinate = new BoundedCoordinate();
		boundedCoordinate.read(message.toString());
		return boundedCoordinate;
	}

	private Error getPutTokenError(BoundedCoordinate boundedCoordinate) {
		assert boundedCoordinate != null;

		Error error = Error.NULL;
		if (!this.player.getBoard().isEmpty(boundedCoordinate)) {
			error = Error.NOT_EMPTY;
		}
		new ErrorView(error).writeln();
		return error;
	}

	private void moveToken() {
		new MessageView(Message.TURN).writeln(this.player.getColor().name());
		BoundedCoordinate origin;
		Error error;
		do {
			origin = this.getCoordinate(Message.COORDINATE_TO_REMOVE);
			error = this.getOriginMoveTokenError(origin);
		} while (error != Error.NULL);
		BoundedCoordinate target;
		do {
			target = this.getCoordinate(Message.COORDINATE_TO_MOVE);
			error = this.getTargetMoveTokenError(origin, target);
		} while (error != Error.NULL);
		this.player.getBoard().moveToken(origin, target);
	}

	private Error getOriginMoveTokenError(BoundedCoordinate origin) {
		assert origin != null;

		Error error = Error.NULL;
		if (!this.player.getBoard().isOccupied(origin, this.player.getColor())) {
			error = Error.NOT_OWNER;
		}
		new ErrorView(error).writeln();
		return error;
	}

	private Error getTargetMoveTokenError(BoundedCoordinate origin, BoundedCoordinate target) {
		assert origin != null;
		assert target != null;

		Error error = Error.NULL;
		if (origin.equals(target)) {
			error = Error.SAME_COORDINATES;
		} else if (!this.player.getBoard().isEmpty(target)) {
			error = Error.NOT_EMPTY;
		}
		new ErrorView(error).writeln();
		return error;
	}

	public void writeWinner() {
		new MessageView(Message.PLAYER_WIN).writeln(this.player.getColor().name());
	}

}
