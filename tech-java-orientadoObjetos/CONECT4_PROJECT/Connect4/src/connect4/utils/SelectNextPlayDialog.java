package connect4.utils;

import connect4.utils.exceptions.MessageNotFoundException;

public class SelectNextPlayDialog extends Dialog<Character> {

    protected ClosedInterval closedInterval;
    protected char charToSave;

    public SelectNextPlayDialog(ClosedInterval closedInterval, char charToSave) throws MessageNotFoundException {
        this.closedInterval = closedInterval;
        this.charToSave = charToSave;
        this.errorMessage = MessageManager.getInstance().getFormatedMessage(
                "NEXT_PLAY_DIALOG_ERROR", closedInterval.getMin(), closedInterval.getMax());
        this.errorMessage += "\n" + MessageManager.getInstance().getFormatedMessage(
                "NEXT_PLAY_DIALOG_ERROR_SUFIX", closedInterval.getMin(), closedInterval.getMax());
        this.suffix = MessageManager.getInstance()
                .getFormatedMessage("NEXT_PLAY_DIALOG_SUFIX",
                        closedInterval.getMin(),
                        closedInterval.getMax());
    }

    public Character askAnswer() {
        return Console.getInstance().readChar(this.suffix);
    }

    public boolean isAnswerOk() {
        if (this.getAnswer() == charToSave) {
            return true;
        }
        if (this.closedInterval.isIncluded(Character.getNumericValue(this.getAnswer())))
            return true;
        return false;
    }

}
