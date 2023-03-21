package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.Connect4;

public class LoadGameOption extends Connect4Option{

    public LoadGameOption(Connect4 connect4) {
        super("Load game", connect4);
    }

    @Override
    public void interact() {
        System.out.println("....menu de cargar LoadGameOption");
    }
    
}
