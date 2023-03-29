package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.views.GameView;
import main.es.pbover.utils.menu.Option;

public abstract class GameOption extends Option {

    protected GameView gameView;

    public GameOption(String title, GameView gameView) {
        super(title);
        this.gameView = gameView;
    }

}
