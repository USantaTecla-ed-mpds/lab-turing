package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.utils.views.menu.Menu;

public class GameSelectMenu extends Menu{

    private StartController startController;

    public GameSelectMenu(StartController startController) {
        super("load game_MESSAGE");
        this.startController = startController;
    }

    @Override
    protected void addOptions() {
        String[] gamesNames = this.startController.getGamesNames();
        for (String gameName : gamesNames) {
            this.add(new GameSelectedOption(gameName, startController));
        }
    }


    
}
