package connect4.views;

import connect4.models.RandomPlayer;
import connect4.utils.exceptions.MessageNotFoundException;

public class RandomPlayerView extends MachinePlayerView {

    public RandomPlayerView(RandomPlayer player) {
        super(player);
    }

    @Override
    public void showOptionSelected(int option) throws MessageNotFoundException {
        MessageManager.getInstance().writeln("SHOW_RANDOM_COLUMN", option);
    }

}
