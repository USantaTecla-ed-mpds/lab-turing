package es.usantatecla.tictactoe;

class YesNoDialog {

	private String answer;

	public void read(String message) {
		assert message != null;

		Console console = Console.getInstance();
		boolean ok;
		do {
			console.write(message);
			this.answer = console.readString(Message.YES_NO_SUFFIX.toString());
			ok = this.isAffirmative() || this.isNegative();
			if (!ok) {
				console.writeln(Message.YES_NO_ERROR.toString());
			}
		} while (!ok);
	}

	public boolean isAffirmative() {
		return this.getAnswer() == Message.AFFIRMATIVE;
	}

	private char getAnswer() {
		return Character.toLowerCase(this.answer.charAt(0));
	}

	public boolean isNegative() {
		return this.getAnswer() == Message.NEGATIVE;
	}

}
