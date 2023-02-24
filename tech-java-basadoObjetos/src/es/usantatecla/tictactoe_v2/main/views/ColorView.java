package es.usantatecla.tictactoe_v2.main.views;

import es.usantatecla.tictactoe_v2.main.models.Color;
import es.usantatecla.tictactoe_v2.main.models.Message;
import es.usantatecla.tictactoe_v2.utils.Console;

public class ColorView {

	private Color color;

	public ColorView(Color color) {
		this.color = color;
	}

	public void write() {
		String string = this.color.name();
		if (this.color.isNull()) {
			string = Message.NULL_COLOR.toString();
		}
		Console.getInstance().write(string);
	}

}
