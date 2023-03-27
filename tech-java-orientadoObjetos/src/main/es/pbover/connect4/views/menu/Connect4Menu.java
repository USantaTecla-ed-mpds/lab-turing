package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.Connect4;
import main.es.pbover.connect4.views.MessageManager;
import main.es.pbover.utils.menu.QuitMenu;

public class Connect4Menu extends QuitMenu{

    private Connect4 connect4;

    public Connect4Menu(Connect4 connect4) {
        super(MessageManager.getInstance().getMessage("CONNECT4_MENU_TITLE"));
        this.connect4 = connect4;
    }

    @Override
    protected void addOptions(){
        this.add(new StartNewGameOption(this.connect4));
        this.add(new LoadGameOption(this.connect4));
    }
}
