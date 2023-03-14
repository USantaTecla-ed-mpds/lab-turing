package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

abstract class WithGameView {

    protected Game game;

    WithGameView(Game game) {
        this.game = game;
    }
    
}
