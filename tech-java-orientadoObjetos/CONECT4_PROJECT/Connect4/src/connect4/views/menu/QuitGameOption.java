package connect4.views.menu;

import java.io.IOException;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;
import connect4.views.dialog.YesNoDialog;

public class QuitGameOption extends Connect4Option {

    public QuitGameOption(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("EXIT"), connect4);
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        final YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.show(MessageManager.getInstance().getMessage("ASK_EXIT"));
        if (yesNoDialog.isAffirmative()) {
            System.exit(0);
        } else
            new Connect4Menu(this.connect4).interact();

    }

}
