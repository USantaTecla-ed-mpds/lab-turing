package connect4.views;

import java.io.IOException;

import connect4.models.HumanPlayer;
import connect4.utils.exceptions.MessageNotFoundException;

public final class HumanPlayerView extends PlayerView {

    public HumanPlayerView(HumanPlayer player) {
        super(player);
    }

    @Override
    public int getColumn() throws MessageNotFoundException, ClassNotFoundException, IOException {
        throw new UnsupportedOperationException("Unimplemented method 'getColumn'");
    }

}
