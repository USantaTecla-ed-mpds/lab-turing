package es.usantatecla.tictactoe_v2.main.models;

import es.usantatecla.tictactoe_v2.utils.ClosedInterval;

public enum Color {

	X,
	O,
	NULL;

	public static Color get(int ordinal) {
		assert new ClosedInterval(0, Color.NULL.ordinal() - 1).isIncluded(ordinal);

		return Color.values()[ordinal];
	}

	public boolean isNull() {
		return this == Color.NULL;
	}
}
