package connect4.views;

import java.io.IOException;

import connect4.Connect4;
import connect4.models.HumanPlayer;
import connect4.models.MinMaxPlayer;
import connect4.models.PlayerVisitor;
import connect4.models.RandomPlayer;
import connect4.models.Turn;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.menu.ConfigTurnMenu;
import connect4.views.menu.TurnMenu;

public class TurnView implements PlayerVisitor {

    private final Turn turn;
    private PlayerView activePlayerView;
    private Connect4 connect4;

    public TurnView(Connect4 connect4, Turn turn) throws MessageNotFoundException {
        this.turn = turn;
        this.connect4 = connect4;
    }

    public void configTurn() throws MessageNotFoundException, ClassNotFoundException, IOException {
        new ConfigTurnMenu(this.turn).interact();
    }

    public void play() throws MessageNotFoundException, IOException, ClassNotFoundException {
        this.turn.getActivePlayer().accept(this);
    }

    public void writeResult() throws MessageNotFoundException {
        if ((this.turn.getBoard()).isWinner()) {
            this.activePlayerView.showWinner();
        } else {
            MessageManager.getInstance().writeln("PLAYERS_TIED");
        }
    }

    public void visit(final HumanPlayer humanPlayer)
            throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.activePlayerView = new HumanPlayerView(humanPlayer);
        TurnMenu turnMenu = new TurnMenu(
                MessageManager.getInstance().getMessage("TURN_MENU",
                        this.activePlayerView.getPlayer().getColor().getString()));
        turnMenu.initialize(this.connect4, this.turn);
        turnMenu.interact();
    }

    public void visit(final RandomPlayer randomPlayer)
            throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.activePlayerView = new RandomPlayerView(randomPlayer);
        int column = this.activePlayerView.getColumn();
        this.turn.play(column);
    }

    public void visit(final MinMaxPlayer minMaxPlayer)
            throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.activePlayerView = new MinMaxPlayerView(minMaxPlayer);
        int column = this.activePlayerView.getColumn();
        this.turn.play(column);
    }
}
