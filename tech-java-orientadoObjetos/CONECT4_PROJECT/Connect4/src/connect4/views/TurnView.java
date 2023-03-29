package connect4.views;

import java.io.IOException;

import connect4.Connect4;
import connect4.models.HumanPlayer;
import connect4.models.MinMaxPlayer;
import connect4.models.PlayerVisitor;
import connect4.models.RandomPlayer;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.menu.ConfigTurnMenu;
import connect4.views.menu.TurnMenu;

public class TurnView implements PlayerVisitor {

    private PlayerView activePlayerView;
    private Connect4 connect4;

    public TurnView(Connect4 connect4) throws MessageNotFoundException {
        this.connect4 = connect4;
    }

    public void configTurn() throws MessageNotFoundException, ClassNotFoundException, IOException {
        new ConfigTurnMenu(this.connect4.getTurn()).interact();
    }

    public void play() throws MessageNotFoundException, IOException, ClassNotFoundException {
        this.connect4.getTurn().getActivePlayer().accept(this);
    }

    public void writeResult() throws MessageNotFoundException {
        if ((this.connect4.getTurn().getBoard()).isWinner()) {
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
                        this.activePlayerView.getPlayer().getColor().getString()),
                this.connect4);
        turnMenu.interact();
    }

    public void visit(final RandomPlayer randomPlayer)
            throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.activePlayerView = new RandomPlayerView(randomPlayer);
        int column = this.activePlayerView.getColumn();
        this.connect4.getTurn().play(column);
    }

    public void visit(final MinMaxPlayer minMaxPlayer)
            throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.activePlayerView = new MinMaxPlayerView(minMaxPlayer);
        int column = this.activePlayerView.getColumn();
        this.connect4.getTurn().play(column);
    }
}
