package connect4.views.dialog;

import connect4.utils.Console;
import connect4.utils.Dialog;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;

public class YesNoDialog extends Dialog<Character> {

	private final char acceptOptionCharacter = 'y';
	private final char cancelOptionCharacter = 'n';

	public YesNoDialog() throws MessageNotFoundException {
		this.suffix = MessageManager.getInstance().getMessage("YESNO_DIALOG_SUFIX");
		this.errorMessage = MessageManager.getInstance().getMessage("YESNO_DIALOG_ERROR");
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
