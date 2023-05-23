package main.es.labturing.connect4.models;

import java.util.HashMap;
import java.util.Map;

import main.es.labturing.connect4.types.PlayerType;

public class PlayersPrototype {

    private Map<PlayerType, Player> playersMap;

    public PlayersPrototype(Board board) {
        this.playersMap =new HashMap<>();
        this.playersMap.put(PlayerType.HUMAN, new HumanPlayer(board));
        this.playersMap.put(PlayerType.RANDOM, new RandomPlayer(board));
        this.playersMap.put(PlayerType.MINMAX, new MinMaxPlayer(board));
    }

    public Player getPlayer(PlayerType playerType) {
        return this.playersMap.get(playerType).clone();
    }

}
