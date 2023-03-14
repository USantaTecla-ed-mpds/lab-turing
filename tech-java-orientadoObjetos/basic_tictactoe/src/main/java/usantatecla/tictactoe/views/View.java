package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

public class View extends WithGameView {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public View(Game game) {
        super(game);
        this.startView = new StartView(this.game);
        this.playView = new PlayView(this.game);
        this.resumeView = new ResumeView(this.game);
    }

    public void start() {
        this.startView.interact();
    }

    public void play() {
        this.playView.interact();
    }

    public boolean resume() {
        return this.resumeView.interact();
    }

}
