package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.Connect4;
import main.es.pbover.utils.menu.QuitMenu;

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
