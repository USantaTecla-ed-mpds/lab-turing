package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;

public class MinMaxPlayerView extends MachinePlayerView {

    public MinMaxPlayerView(PlayController playController) {
        super(playController);
    }

    public void showColumnSelected(int column) {
        MessageManager.getInstance().writeln("SHOW_MINMAX_COLUMN", String.valueOf(column + 1));
    }
}