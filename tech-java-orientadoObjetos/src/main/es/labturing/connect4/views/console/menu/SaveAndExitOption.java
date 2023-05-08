package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.models.GameManager;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.Option;

public class SaveAndExitOption extends Option {

    private GameManager gameManager;

    public SaveAndExitOption(GameManager gameManager) {
        super(MessageManager.getInstance().getMessage("SAVE AND EXIT"));
        this.gameManager = gameManager;
    }

    public void interact() {
        gameManager.save();
    }
    
}
