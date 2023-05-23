package main.es.labturing.connect4.views.console;

public class MinMaxPlayerView extends MachinePlayerView {

    public MinMaxPlayerView() {
    }

    public void showColumnSelected(int column) {
        MessageManager.getInstance().writeln("SHOW_MINMAX_COLUMN", String.valueOf(column + 1));
    }
}