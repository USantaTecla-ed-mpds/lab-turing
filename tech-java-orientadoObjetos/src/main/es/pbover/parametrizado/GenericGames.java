package main.es.pbover.parametrizado;

import main.es.pbover.connect4.models.Game;

import main.es.pbover.parametrizado.GenericGameView;

public class GenericGames<G> {

    private G game;
    private GenericGameView<Game> gameView;

    public GenericGames(G game) {
        this.game = game;
        this.gameView = new GenericGameView<Game>(this.game);

    }

    private void play() {
        do {
            this.gameView.start();
            this.gameView.play();
        } while (this.gameView.resume());
    }

}
