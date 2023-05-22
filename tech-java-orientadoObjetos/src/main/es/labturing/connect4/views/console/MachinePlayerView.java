package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;

public abstract class MachinePlayerView extends PlayerView {

    public MachinePlayerView(PlayController playController) {
        super(playController);
    }

    public void dropToken(){
        this.playController.dropToken(this.getColumn());
    }

    private int getColumn() {
        int column = this.playController.getActiveMachineColumn();
        this.showColumnSelected(column);
        return column;
    }

    protected abstract void showColumnSelected(int column);
    
}
