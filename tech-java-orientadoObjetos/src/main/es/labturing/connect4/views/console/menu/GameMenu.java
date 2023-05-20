package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.connect4.views.console.TurnView;
import main.es.labturing.utils.views.menu.Menu;

public class GameMenu extends Menu{

    private TurnView turnView;
    private StartController startController;

    public GameMenu(TurnView turnView, StartController startController) {
        super(MessageManager.getInstance().getMessage("GAME_MENU_TITLE"));
        this.turnView = turnView;
        this.startController = startController;
    }

    @Override
    protected void addOptions(){
        this.add(new StartNewGameOption(this.turnView, startController));
        if(this.startController.isGamePersisted()){
            this.add(new LoadGameOption(this.startController));
        }
    }
}
