package main.es.pbover.connect4Old.views;

import main.es.pbover.connect4Old.models.HumanPlayer;
import main.es.pbover.connect4Old.models.MinMaxPlayer;
import main.es.pbover.connect4Old.models.PlayerVisitor;
import main.es.pbover.connect4Old.models.RandomPlayer;
import main.es.pbover.connect4Old.models.Turn;
import main.es.pbover.utils.ClosedIntervalDialog;

public class TurnView implements PlayerVisitor {
    private Turn turn;
    private PlayerView activePlayerView;

    public TurnView(Turn turn) {
        super();
        this.turn = turn;
    }
    public void getNumberOfHumanPlayers() { 
        ClosedIntervalDialog closedIntervalDialog = new ClosedIntervalDialog(0, this.turn.getNumberPlayers());
        closedIntervalDialog.read(Message.NUM_PLAYERS.toString());
        this.turn.reset(closedIntervalDialog.getAnswer());
    }
    public void getMachineTypePlayer() { 
        ClosedIntervalDialog closedIntervalDialog = new ClosedIntervalDialog(1, 2);
        closedIntervalDialog.read(Message.TYPE_MACHINE.toString());
        this.turn.setTypeMachine(closedIntervalDialog.getAnswer());
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
