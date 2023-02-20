package es.usantatecla.tictactoe_v2.main.models;

import es.usantatecla.tictactoe_v2.utils.ClosedInterval;
import es.usantatecla.tictactoe_v2.utils.Console;

public enum Color {

	X,
	O,
	NULL;

	public static Color get(int ordinal) {
		assert new ClosedInterval(0, Color.NULL.ordinal()-1).isIncluded(ordinal);

		return Color.values()[ordinal];
	}

	public void write() {
		String string = this.name();
		if (this.isNull()) {
			string = Message.NULL_COLOR.toString();
		}
		Console.getInstance().write(string);
	}

	public boolean isNull() {
		return this == Color.NULL;
	}
}
