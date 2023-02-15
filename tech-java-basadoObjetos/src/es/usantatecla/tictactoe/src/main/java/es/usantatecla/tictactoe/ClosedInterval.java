package es.usantatecla.tictactoe;

class ClosedInterval {

	private int min;
	private int max;

	public ClosedInterval(int min, int max) {
		assert min <= max;

		this.min = min;
		this.max = max;
	}

	public boolean isIncluded(int value) {
		return this.min <= value && value <= this.max;
	}

	public String toString() {
		return Message.CLOSED_INTERVAL.toString()
				.replaceAll(Message.$MIN, String.valueOf(this.min))
				.replaceAll(Message.$MAX, String.valueOf(this.max));
	}

	public boolean equals(ClosedInterval closedInterval) {
		if (this == closedInterval)
			return true;
		if (closedInterval == null)
			return false;
		if (this.min != closedInterval.min)
			return false;
		if (this.max != closedInterval.max)
			return false;
		return true;
	}

}
