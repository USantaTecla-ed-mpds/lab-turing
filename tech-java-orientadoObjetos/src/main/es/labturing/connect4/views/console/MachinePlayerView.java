package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;

public abstract class MachinePlayerView extends PlayerView {

    public MachinePlayerView() {
    }

    public void play(PlayController playController){
        playController.dropToken(this.getColumn(playController));
    }

    private int getColumn(PlayController playController) {
        int column = playController.getActiveMachineColumn();
        this.showColumnSelected(column);
        return column;
    }

    protected abstract void showColumnSelected(int column);
    
}
