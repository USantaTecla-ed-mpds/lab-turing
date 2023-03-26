package connect4.views;

import java.io.IOException;

import connect4.Connect4;
import connect4.models.HumanPlayer;
import connect4.models.MinMaxPlayer;
import connect4.models.PlayerVisitor;
import connect4.models.RandomPlayer;
import connect4.models.Turn;
import connect4.utils.exceptions.MessageNotFoundException;

public class TurnView implements PlayerVisitor {
    private final Connect4 connect4;
    private final Turn turn;
    private PlayerView activePlayerView;

    public TurnView(Connect4 connect4) {
        super();
        this.connect4 = connect4;
        this.turn = connect4.getTurn();
    }

    public void play() throws MessageNotFoundException, IOException {
        this.turn.getActivePlayer().accept(this);

        int column = this.activePlayerView.getColumn();

        if (column == -1) {
            this.connect4.saveGame();
        } else {
            this.turn.play(column);
        }
    }

    public void writeResult() throws MessageNotFoundException {
        if ((this.turn.getBoard()).isWinner()) {
            this.activePlayerView.showWinner();
        } else {
            MessageManager.getInstance().writeln("PLAYERS_TIED");
        }
    }

    public void visit(final HumanPlayer humanPlayer) {
        this.activePlayerView = new HumanPlayerView(humanPlayer);
    }

    public void visit(final RandomPlayer randomPlayer) {
        this.activePlayerView = new RandomPlayerView(randomPlayer);
    }

    public void visit(final MinMaxPlayer minMaxPlayer) {
        this.activePlayerView = new MinMaxPlayerView(minMaxPlayer);
    }
}
