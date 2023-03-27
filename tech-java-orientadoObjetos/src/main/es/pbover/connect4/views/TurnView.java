package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.GameManager;
import main.es.pbover.connect4.models.HumanPlayer;
import main.es.pbover.connect4.models.MinMaxPlayer;
import main.es.pbover.connect4.models.PlayerVisitor;
import main.es.pbover.connect4.models.RandomPlayer;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.connect4.views.menu.ConfigTurnMenu;
import main.es.pbover.connect4.views.menu.SaveAndExitOrContinueMenu;

public class TurnView implements PlayerVisitor {
    private final Turn turn;
    private PlayerView activePlayerView;
    private GameManager gameManager;

    public TurnView(final Turn turn, GameManager gameManager) {
        super();
        this.turn = turn;
        this.gameManager = gameManager;
    }

    public void configTurn() {
        new ConfigTurnMenu(this.turn).interact();
    }

    public void play() {
        this.turn.getActivePlayer().accept(this);
        this.turn.play(this.activePlayerView.getColumn());
    }

    public void writeResult() {
        if ((this.turn.getBoard()).isWinner()) {
            this.activePlayerView.showWinner();
        } else {
            MessageManager.getInstance().writeln("PLAYERS_TIED");
        }
    }

    public void visit(final HumanPlayer humanPlayer) {
        this.activePlayerView = new HumanPlayerView(humanPlayer);
        new SaveAndExitOrContinueMenu(this.gameManager).interact();
    }

    public void visit(final RandomPlayer randomPlayer) {
        this.activePlayerView = new RandomPlayerView(randomPlayer);
    }

    public void visit(final MinMaxPlayer minMaxPlayer) {
        this.activePlayerView = new MinMaxPlayerView(minMaxPlayer);
    }
}
