package connect4.views.menu;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;
import connect4.views.menu.option.AskColumnToHumanPlayerOption;
import connect4.views.menu.option.LoadGameOption;
import connect4.views.menu.option.QuitTurnMenuOption;
import connect4.views.menu.option.SaveGameOption;

public class TurnMenu extends Connect4Menu {

    public TurnMenu(String title, Connect4 connect4) throws MessageNotFoundException {
        super(title, connect4);
    }

    @Override
    protected void addOptions() throws MessageNotFoundException {
        String askColumnToPlayerTitle = MessageManager.getInstance().getMessage("ASK_COLUMN_TO_DROP");
        String saveGameOptionTitle = MessageManager.getInstance().getMessage("SAVE_GAME_OPTION");
        this.add(new AskColumnToHumanPlayerOption(askColumnToPlayerTitle, this.connect4.getTurn()));
        this.add(new LoadGameOption(this.connect4));
        this.add(new SaveGameOption(saveGameOptionTitle, this.connect4));
    }

    @Override
    protected void addQuitOption() throws MessageNotFoundException {
        this.add(new QuitTurnMenuOption(this.connect4));
    }

}
