package main.es.pbover.connecta$.views.menu;

import main.es.pbover.utils.menu.QuitMenu;
import main.es.pbover.connecta$.Connect4;

public class Connect4Menu extends QuitMenu{

    private Connect4 Connect4;

    public Connect4Menu(Connect4 connect4) {
        super("Connect4 menu");
        this.Connect4 = connect4;
    }

    @Override
    protected void addOptions(){
        this.add(new StartNewGameOption(this.Connect4));
        this.add(new LoadGameOption(this.Connect4));
    }
}
