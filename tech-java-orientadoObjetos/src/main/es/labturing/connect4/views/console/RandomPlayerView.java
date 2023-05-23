package main.es.labturing.connect4.views.console;

public class RandomPlayerView extends MachinePlayerView {

    public RandomPlayerView() {
    }

    public void showColumnSelected(int column) {
        MessageManager.getInstance().writeln("SHOW_RANDOM_COLUMN", String.valueOf(column + 1));
    }
}
