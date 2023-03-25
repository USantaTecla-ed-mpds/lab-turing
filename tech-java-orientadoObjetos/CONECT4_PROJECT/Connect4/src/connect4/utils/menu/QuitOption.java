package connect4.utils.menu;

import connect4.utils.MessageManager;
import connect4.utils.exceptions.MessageNotFoundException;

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
