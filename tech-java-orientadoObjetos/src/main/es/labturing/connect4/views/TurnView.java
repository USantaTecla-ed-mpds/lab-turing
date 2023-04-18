package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.Turn;
import main.es.labturing.connect4.views.menu.ConfigTurnMenu;

public class TurnView {
    private final Turn turn;
    private PlayerView activePlayerView;
    private PlayerViewPrototype playerViewPrototype;

    public TurnView(Turn turn) {
        super();
        this.turn = turn;
    }

    public void configTurn() {
        new ConfigTurnMenu(this.turn).interact();
    }

    public void play() {
        this.playerViewPrototype = new PlayerViewPrototype(this.turn);
        this.activePlayerView = this.playerViewPrototype.createView(this.turn.getType());
        this.turn.play(this.activePlayerView.getColumn());
    }

    public void writeResult() {
        if ((this.turn.getBoard()).isWinner()) {
            this.activePlayerView.showWinner();
        } else {
            MessageManager.getInstance().writeln("PLAYERS_TIED");
        }
    }
}
