package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;

public class RandomPlayerView extends MachinePlayerView {

    public RandomPlayerView(PlayController playController) {
        super(playController);
    }

    public void showColumnSelected(int column) {
        MessageManager.getInstance().writeln("SHOW_RANDOM_COLUMN", String.valueOf(column + 1));
    }
}
