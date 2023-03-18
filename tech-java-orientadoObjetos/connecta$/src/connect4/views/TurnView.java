package connect4.views;

import connect4.utils.InIntervalDialog;
import connect4.models.Color;
import connect4.models.HumanPlayer;
import connect4.models.Message;
import connect4.models.MinMaxPlayer;
import connect4.models.Player;
import connect4.models.PlayerVisitor;
import connect4.models.RandomPlayer;
import connect4.models.Turn;

public class TurnView implements PlayerVisitor {
    private Turn turn;
    private PlayerView activePlayerView;

    public TurnView(Turn turn) {
        super();
        this.turn = turn;
    }

    public void initPlayers() {
        InIntervalDialog inIntervalDialog = new InIntervalDialog(0, this.turn.getNumberPlayers());
        inIntervalDialog.read(Message.NUM_PLAYERS.toString());

        Player[] players = new Player[this.turn.getNumberPlayers()];
        for (int i = 0; i < this.turn.getNumberPlayers(); i++) {
            players[i] = i < inIntervalDialog.getAnswer() ? new HumanPlayer(Color.get(i), this.turn.getBoard())
                    : getMachinePlayerType(Color.get(i));
        }
        this.turn.reset(players);
    }

    private Player getMachinePlayerType(Color color) {
        InIntervalDialog inIntervalDialog = new InIntervalDialog(1, 2);
        inIntervalDialog.read(Message.TYPE_MACHINE.getFormated(color.getString()));

        if (inIntervalDialog.getAnswer() == 1)
            return new RandomPlayer(color, this.turn.getBoard());
        return new MinMaxPlayer(color, this.turn.getBoard());
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
