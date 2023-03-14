package usantatecla.utils.views;

public class YesNoDialog {

	private static final char AFFIRMATIVE = 'y';
	private static final char NEGATIVE = 'n';
	private static final String SUFFIX = "? (" +
		YesNoDialog.AFFIRMATIVE+"/" + 
		YesNoDialog.NEGATIVE+"): ";
	private static final String MESSAGE = "The value must be '" + 
		YesNoDialog.AFFIRMATIVE + "' or '" + 
		YesNoDialog.NEGATIVE + "'";
	private String answer;

	public void read(String message) {
		assert message != null;

		Console console = Console.getInstance();
		boolean ok;
		do {
			console.write(message);
			this.answer = console.readString(YesNoDialog.SUFFIX);
			ok = this.isAffirmative() || this.isNegative();
			if (!ok) {
				console.writeln(YesNoDialog.MESSAGE);
			}
		} while (!ok);
	}
	
	public boolean isAffirmative() {
		return this.getAnswer() == YesNoDialog.AFFIRMATIVE;
	}
	
	private char getAnswer(){
		return Character.toLowerCase(this.answer.charAt(0));
	}

	public boolean isNegative() {
		return this.getAnswer() == YesNoDialog.NEGATIVE;
	}

}
