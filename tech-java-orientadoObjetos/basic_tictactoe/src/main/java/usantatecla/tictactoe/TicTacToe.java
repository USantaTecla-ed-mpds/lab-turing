package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

class TicTacToe {

    private Game game;
    private View view;

    TicTacToe() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    private void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }

}
