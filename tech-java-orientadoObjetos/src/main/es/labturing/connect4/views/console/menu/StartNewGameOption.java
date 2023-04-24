package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.views.console.GameView;
import main.es.labturing.connect4.views.console.MessageManager;

public class StartNewGameOption extends GameOption {

    public StartNewGameOption(GameView gameView) {
        super(MessageManager.getInstance().getMessage("START"),gameView);
    }

    @Override
    public void interact() {
        this.gameView.play();
    }

}
