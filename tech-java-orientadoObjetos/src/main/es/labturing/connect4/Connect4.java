package main.es.labturing.connect4;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.views.GameView;
import main.es.labturing.utils.framework.GameApp;

public class Connect4 extends GameApp<Game, GameView> {

    public Connect4() {
        this.game = new Game();
        this.gameView = new GameView(this.game);

    }

    public static void main(final String[] args) {
        new Connect4().play();
    }

}
