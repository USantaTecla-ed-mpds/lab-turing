package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.Option;

public class LoadGameOption extends Option{

    private StartController startController;

    public LoadGameOption(StartController startController) {
        super(MessageManager.getInstance().getMessage("LOAD"));
        this.startController = startController;

    }

    @Override 
    public boolean isActive(){
        return this.startController.getGamesNames().length != 0;
    }

    @Override
    public void interact() {
        new GameSelectMenu(this.startController).interact();
    }
    
}
