package connect4.utils;

public class YesNoDialog extends Dialog<Character> {

	private final char acceptOptionCharacter = 'y';
	private final char cancelOptionCharacter = 'n';

	public YesNoDialog() {
		this.suffix = "[y or n]: ";
	}

	@Override
	public boolean isAnswerOk() {
		return this.answer == acceptOptionCharacter || this.answer == cancelOptionCharacter;
	}

	@Override
	protected Character askAnswer() {
		return Console.getInstance().readChar(this.suffix);
	}

	public boolean isAffirmative() {
		return this.getAnswer().equals(acceptOptionCharacter);
	}

	public boolean isNegative() {
		return this.getAnswer().equals(cancelOptionCharacter);
	}

}
