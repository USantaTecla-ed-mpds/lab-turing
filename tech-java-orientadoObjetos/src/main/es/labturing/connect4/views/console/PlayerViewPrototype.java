package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.models.Turn;
import main.es.labturing.connect4.types.PlayerType;

import java.util.HashMap;

public class PlayerViewPrototype {

    private HashMap<PlayerType, PlayerView> playerViewsMap;

    PlayerViewPrototype(Turn turn) {
        this.playerViewsMap = new HashMap<>();
        this.playerViewsMap.put(PlayerType.HUMAN, new HumanPlayerView(turn));
        this.playerViewsMap.put(PlayerType.RANDOM, new RandomPlayerView(turn));
        this.playerViewsMap.put(PlayerType.MINMAX, new MinMaxPlayerView(turn));
    }

    PlayerView createView(PlayerType playerType) {
        return this.playerViewsMap.get(playerType);
    }
}
