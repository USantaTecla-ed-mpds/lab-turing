package es.usantatecla.tictactoe_v2.main.views;

import es.usantatecla.tictactoe_v2.main.models.Message;
import es.usantatecla.tictactoe_v2.utils.Console;

public class MessageView {

	private Message message;

	MessageView(Message message) {
		this.message = message;
	}

	public void write() {
		Console.getInstance().write(this.message.toString());
	}

	public void writeln() {
		Console.getInstance().writeln(this.message.toString());
	}

	public void writeln(String string) {
		assert string != null;
		assert this.message == Message.PLAYER_WIN || this.message == Message.TURN;

		String parameter = this.message == Message.PLAYER_WIN ? Message.$PLAYER : Message.$COLOR;
		Console.getInstance().writeln(this.message.toString().replaceAll(parameter, string));
	}

}
