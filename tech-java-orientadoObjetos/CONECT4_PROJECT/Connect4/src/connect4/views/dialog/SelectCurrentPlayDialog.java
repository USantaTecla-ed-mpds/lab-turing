package connect4.views.dialog;

import connect4.utils.ClosedInterval;
import connect4.utils.Console;
import connect4.utils.Dialog;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;

public class SelectCurrentPlayDialog extends Dialog<Integer> {

    protected ClosedInterval closedInterval;

    public SelectCurrentPlayDialog(ClosedInterval closedInterval) throws MessageNotFoundException {
        this.closedInterval = closedInterval;
        this.errorMessage = MessageManager.getInstance().getMessage(
                "CURRENT_PLAY_DIALOG_ERROR", closedInterval.getMin(), closedInterval.getMax());
        this.suffix = MessageManager.getInstance()
                .getMessage("CURRENT_PLAY_DIALOG_SUFIX",
                        closedInterval.getMin(),
                        closedInterval.getMax());
    }

    public Integer askAnswer() {
        return Console.getInstance().readInt(this.suffix);
    }

    public boolean isAnswerOk() {
        return this.closedInterval.isIncluded(this.getAnswer());
    }

}
