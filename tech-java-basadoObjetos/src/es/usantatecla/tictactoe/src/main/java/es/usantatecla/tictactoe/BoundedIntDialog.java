package es.usantatecla.tictactoe;

class BoundedIntDialog {

	private ClosedInterval LIMITS;

	public BoundedIntDialog(int min, int max) {
		assert min <= max;

		this.LIMITS = new ClosedInterval(min, max);
	}

	public int read(String message) {
		assert message != null;

		boolean ok;
		int value;
		do {
			value = Console.getInstance().readInt(message + this.getLimits());
			ok = this.LIMITS.isIncluded(value);
			if (!ok) {
				Console.getInstance().writeln(Message.BOUNDED_INT_ERROR.toString());
			}
		} while (!ok);
		return value;
	}

	private String getLimits() {
		return Message.LIMITS.toString()
			.replace(Message.$CLOSED_INTERVAL, this.LIMITS.toString());
	}

}
