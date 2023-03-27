package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.GameManager;
import main.es.pbover.connect4.views.MessageManager;
import main.es.pbover.utils.menu.Option;

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
