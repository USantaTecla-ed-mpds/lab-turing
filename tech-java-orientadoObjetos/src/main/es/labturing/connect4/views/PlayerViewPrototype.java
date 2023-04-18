package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.Turn;
import main.es.labturing.connect4.types.PlayerType;

import java.util.HashMap;

public class PlayerViewPrototype {

    private HashMap<PlayerType, PlayerView> playerViewAsoc;

    PlayerViewPrototype(Turn turn) {
        this.playerViewAsoc = new HashMap<>();
        this.playerViewAsoc.put(PlayerType.HUMAN, new HumanPlayerView(turn));
        this.playerViewAsoc.put(PlayerType.RANDOM, new RandomPlayerView(turn));
        this.playerViewAsoc.put(PlayerType.MINMAX, new MinMaxPlayerView(turn));
    }

    PlayerView createView(PlayerType playerType) {
        return this.playerViewAsoc.get(playerType);
    }
}
