package connect4.views.menu.option;

import java.io.IOException;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;
import connect4.views.dialog.YesNoDialog;
import connect4.views.menu.Connect4Menu;

public class QuitTurnMenuOption extends Connect4Option {

    public QuitTurnMenuOption(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("EXIT"), connect4);
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {

        final YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.show(MessageManager.getInstance().getMessage("ASK_EXIT"));
        if (yesNoDialog.isAffirmative()) {
            this.connect4.showSaveGameDialog();
        }
        new Connect4Menu(MessageManager.getInstance().getMessage("GAME_TITLE"), this.connect4).interact();
    }

}
