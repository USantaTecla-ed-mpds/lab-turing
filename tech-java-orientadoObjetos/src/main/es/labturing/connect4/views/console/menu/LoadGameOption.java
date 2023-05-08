package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.models.GameManager;
import main.es.labturing.connect4.views.console.GameView;
import main.es.labturing.connect4.views.console.MessageManager;

public class LoadGameOption extends GameOption{

    private GameManager gameManager;

    public LoadGameOption(GameView gameView) {
        super(MessageManager.getInstance().getMessage("LOAD"),gameView);
       //TODO: this.gameManager = connect4.getGameManager();
    }

    @Override
    public void interact() {
        this.gameManager.load();
    }
    
}
