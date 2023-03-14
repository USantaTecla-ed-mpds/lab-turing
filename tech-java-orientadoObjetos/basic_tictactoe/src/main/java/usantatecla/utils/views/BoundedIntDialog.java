package usantatecla.utils.views;

import usantatecla.utils.models.ClosedInterval;

public class BoundedIntDialog {

	private ClosedInterval LIMITS;
	private static final String ERROR_MESSAGE = "Invalid number";

	public BoundedIntDialog(int min, int max){
		this.LIMITS = new ClosedInterval(min, max);
	}

	public int read(String message) {
		assert message != null;

		boolean ok;
		int value;
		do {
			value = Console.getInstance().readInt(message + "? " + this.LIMITS + ": ");
			ok = this.LIMITS.isIncluded(value);
			if (!ok) {
				Console.getInstance().writeln(BoundedIntDialog.ERROR_MESSAGE);
			}
		} while(!ok);
		return value;
	}
    
}
