package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.HumanPlayer;
import main.es.labturing.connect4.models.MinMaxPlayer;
import main.es.labturing.connect4.models.PlayerVisitor;
import main.es.labturing.connect4.models.RandomPlayer;
import main.es.labturing.connect4.models.Turn;
import main.es.labturing.connect4.views.menu.ConfigTurnMenu;

public class TurnView implements PlayerVisitor {
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
        this.turn.getActivePlayer().accept(this);//
        this.turn.play(this.activePlayerView.getColumn());
    }

    public void writeResult() {
        if ((this.turn.getBoard()).isWinner()) {
            this.activePlayerView.showWinner();
        } else {
            MessageManager.getInstance().writeln("PLAYERS_TIED");
        }
    }

    public void visit(HumanPlayer humanPlayer) {
        this.activePlayerView = new HumanPlayerView(humanPlayer);
    }

    public void visit(RandomPlayer randomPlayer) {
        this.activePlayerView = new RandomPlayerView(randomPlayer);
    }

    public void visit(MinMaxPlayer minMaxPlayer) {
        this.activePlayerView = new MinMaxPlayerView(minMaxPlayer);
    }
}
