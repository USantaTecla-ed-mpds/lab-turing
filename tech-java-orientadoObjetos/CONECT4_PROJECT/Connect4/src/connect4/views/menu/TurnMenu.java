package connect4.views.menu;

import connect4.Connect4;
import connect4.models.Player;
import connect4.models.Turn;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.utils.menu.QuitMenu;
import connect4.views.MessageManager;

public class TurnMenu extends QuitMenu {

    private Player activePlayer;
    private Turn turn;
    private Connect4 connect4;

    public TurnMenu(String title) throws MessageNotFoundException {
        super(title);
    }

    @Override
    protected void addOptions() throws MessageNotFoundException {
        String askColumnToPlayerTitle = MessageManager.getInstance().getMessage("ASK_COLUMN_TO_DROP");
        String saveGameOptionTitle = MessageManager.getInstance().getMessage("SAVE_GAME_OPTION");
        this.add(new AskColumnToPlayerOption(askColumnToPlayerTitle, activePlayer, turn));
        this.add(new LoadGameOption(this.connect4));
        this.add(new SaveGameOption(saveGameOptionTitle));
    }

    @Override
    protected void addQuitOption() throws MessageNotFoundException {
        this.add(new QuitTurnMenuOption(this.connect4));
    }

    public void initialize(Connect4 connect4, Turn turn) {
        this.activePlayer = turn.getActivePlayer();
        this.turn = turn;
        this.connect4 = connect4;
    }

}
