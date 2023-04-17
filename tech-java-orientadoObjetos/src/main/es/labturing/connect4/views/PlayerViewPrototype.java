package main.es.labturing.connect4.views;

import main.es.labturing.connect4.types.PlayerType;

import java.util.HashMap;

public class PlayerViewPrototype {

    private HashMap<PlayerType, PlayerView> playerViewAsoc;

    PlayerViewPrototype() {
        this.playerViewAsoc = new HashMap<>();
        this.playerViewAsoc.put(PlayerType.HUMAN, new HumanPlayerView());
        this.playerViewAsoc.put(PlayerType.RANDOM, new RandomPlayerView());
        this.playerViewAsoc.put(PlayerType.MINMAX, new MinMaxPlayerView());
    }

    PlayerView createView(PlayerType playerType) {
        return this.playerViewAsoc.get(playerType);
    }
}
