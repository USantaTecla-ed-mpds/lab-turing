package connect4.utils.menu;

import connect4.models.exceptions.MessageNotFoundException;
import connect4.utils.MessageManager;

public class QuitOption extends Option {

    private boolean executed;

    public QuitOption() throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("EXIT"));
        this.executed = false;
    }

    @Override
    public void interact() {
        this.executed = true;
    }

    public boolean isExecuted() {
        return this.executed;
    }

}
