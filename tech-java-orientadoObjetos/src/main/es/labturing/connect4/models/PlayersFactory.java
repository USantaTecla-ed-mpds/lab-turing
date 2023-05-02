package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.PlayerType;

public class PlayersFactory {

    public PlayersFactory() {
    }

    public PlayerCreator getPlayerCreator(PlayerType playerType) {
        if (playerType == PlayerType.HUMAN) {
            return new HumanPlayerCreator();
        } else if (playerType == PlayerType.RANDOM) {
            return new RandomPlayerCreator();
        } else {
            return new MinMaxPlayerCreator();
        }
    }

}
