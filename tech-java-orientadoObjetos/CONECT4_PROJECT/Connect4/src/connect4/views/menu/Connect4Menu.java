package connect4.views.menu;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.utils.menu.QuitMenu;
import connect4.views.menu.option.LanguageOption;
import connect4.views.menu.option.LoadGameOption;
import connect4.views.menu.option.QuitGameOption;
import connect4.views.menu.option.StartNewGameOption;

public class Connect4Menu extends QuitMenu {

    protected Connect4 connect4;

    public Connect4Menu(String title, Connect4 connect4) throws MessageNotFoundException {
        super(title);
        this.connect4 = connect4;
    }

    @Override
    protected void addOptions() throws MessageNotFoundException {
        this.add(new StartNewGameOption(this.connect4));
        this.add(new LoadGameOption(this.connect4));
        this.add(new LanguageOption(this.connect4));
    }

    protected void addQuitOption() throws MessageNotFoundException {
        this.add(new QuitGameOption(this.connect4));
    }

}
