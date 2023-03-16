package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.HumanPlayer;
import main.es.pbover.connect4.models.MinMaxPlayer;
import main.es.pbover.connect4.models.PlayerVisitor;
import main.es.pbover.connect4.models.RandomPlayer;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.utils.InIntervalDialog;

public class TurnView implements PlayerVisitor {
    private Turn turn;
    private PlayerView activePlayerView;

    public TurnView(Turn turn) {
        super();
        this.turn = turn;
    }
    public void setNumberOfHumanPlayers() { 
        InIntervalDialog inIntervalDialog = new InIntervalDialog(0, this.turn.getNumberPlayers());
        inIntervalDialog.read(Message.NUM_PLAYERS.toString());
        this.turn.reset(inIntervalDialog.getAnswer());
    }

    public void play() {
        this.turn.getActivePlayer().accept(this);
        this.turn.play(this.activePlayerView.getColumn());
    }

    public void writeResult() {
        if ((this.turn.getBoard()).isWinner()) {
            this.activePlayerView.writeWinner();
        } else {
            Message.PLAYERS_TIED.writeln();
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
