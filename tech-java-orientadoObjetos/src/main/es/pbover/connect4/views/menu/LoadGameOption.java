package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.Connect4;
import main.es.pbover.connect4.views.MessageManager;

public class LoadGameOption extends Connect4Option{

    public LoadGameOption(Connect4 connect4) {
        super(MessageManager.getInstance().getMessage("LOAD"), connect4);
    }

    @Override
    public void interact() {
        System.out.println("....menu de cargar LoadGameOption");
    }
    
}
