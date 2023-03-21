package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.models.PlayerVisitor;
import main.es.pbover.connecta$.models.HumanPlayer;
import main.es.pbover.connecta$.models.MinMaxPlayer;
import main.es.pbover.connecta$.models.RandomPlayer;
import main.es.pbover.connecta$.models.Message;
import main.es.pbover.connecta$.models.Turn;
import main.es.pbover.connecta$.models.Player;
import main.es.pbover.connecta$.models.Color;
import main.es.pbover.connecta$.models.PlayerFactory;
import main.es.pbover.utils.InIntervalDialog;


public class TurnView implements PlayerVisitor {
    private final Turn turn;
    private PlayerView activePlayerView;

    public TurnView(final Turn turn) {
        super();
        this.turn = turn;
    }

    public void initPlayers() {
        final InIntervalDialog inIntervalDialog = new InIntervalDialog(0, this.turn.getNumberPlayers());
        inIntervalDialog.read(Message.ASK_NUM_PLAYERS.toString());

        final Player[] players = new Player[this.turn.getNumberPlayers()];
        for (int i = 0; i < this.turn.getNumberPlayers(); i++) {
            players[i] = i < inIntervalDialog.getAnswer() ? PlayerFactory.buildPlayerFromOption(
                    0,
                    Color.get(i),
                    this.turn.getBoard())
                    : getMachinePlayerType(Color.get(i));
        }

        //this.turn.reset(players);
    }

    private Player getMachinePlayerType(final Color color) {
        final InIntervalDialog inIntervalDialog = new InIntervalDialog(1, 2);
        inIntervalDialog.read(Message.ASK_MACHINE_TYPE.getFormatedMessage(color.getString()));

        final Player player = PlayerFactory.buildPlayerFromOption(
                inIntervalDialog.getAnswer(),
                color,
                this.turn.getBoard());

        return player;

    }

    public void play() {
        this.turn.getActivePlayer().accept(this);
        this.turn.play(this.activePlayerView.getColumn());
    }

    public void writeResult() {
        if ((this.turn.getBoard()).isWinner()) {
            this.activePlayerView.showWinner();
        } else {
            MessageView.getInstance().writeln(Message.PLAYERS_TIED);
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
