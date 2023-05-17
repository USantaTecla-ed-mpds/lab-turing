package main.es.labturing.utils.framework;

public class GameApp<G, V extends GameView> {

    protected G game;
    protected V gameView;

    protected void interact() {
        do {
            this.gameView.start();
            this.gameView.play();
        } while (this.gameView.resume());
    }
}
