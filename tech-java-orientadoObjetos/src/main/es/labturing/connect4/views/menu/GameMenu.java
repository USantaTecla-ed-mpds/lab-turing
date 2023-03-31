package main.es.labturing.connect4.views.menu;

import main.es.labturing.connect4.views.GameView;
import main.es.labturing.connect4.views.MessageManager;
import main.es.labturing.utils.views.menu.QuitMenu;

public class GameMenu extends QuitMenu{

    private GameView gameView;

    public GameMenu(GameView gameView) {
        super(MessageManager.getInstance().getMessage("GAME_MENU_TITLE"));
        this.gameView = gameView;
    }

    @Override
    protected void addOptions(){
        this.add(new StartNewGameOption(this.gameView));
      //  this.add(new LoadGameOption(this.gameView));
    }
}
