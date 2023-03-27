package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.Connect4;
import main.es.pbover.connect4.models.GameManager;
import main.es.pbover.connect4.views.MessageManager;

public class LoadGameOption extends Connect4Option{

    private GameManager gameManager;

    public LoadGameOption(Connect4 connect4) {
        super(MessageManager.getInstance().getMessage("LOAD"), connect4);
        this.gameManager = connect4.getGameManager();
    }

    @Override
    public void interact() {
        this.gameManager.load(this.connect4);
    }
    
}
