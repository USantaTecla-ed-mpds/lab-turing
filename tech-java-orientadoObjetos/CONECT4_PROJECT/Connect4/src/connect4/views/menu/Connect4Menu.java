package connect4.views.menu;

import connect4.Connect4;
import connect4.models.exceptions.MessageNotFoundException;
import connect4.utils.menu.QuitMenu;

public class Connect4Menu extends QuitMenu {

    private Connect4 Connect4;

    public Connect4Menu(Connect4 connect4) throws MessageNotFoundException {
        super("Connect4 menu");
        this.Connect4 = connect4;
    }

    @Override
    protected void addOptions() throws MessageNotFoundException {
        this.add(new StartNewGameOption(this.Connect4));
        this.add(new LoadGameOption(this.Connect4));
    }

}
