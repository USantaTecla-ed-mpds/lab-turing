package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.PlayerType;

import java.util.HashMap;

public class PlayerPrototype {

        private HashMap<PlayerType, Player> playersMap;
    
        PlayerPrototype(Board board) {
            this.playersMap = new HashMap<>();
            this.playersMap.put(PlayerType.HUMAN, new HumanPlayer(board));
            this.playersMap.put(PlayerType.RANDOM, new RandomPlayer(board));
            this.playersMap.put(PlayerType.MINMAX, new MinMaxPlayer(board));
        }
        Player createModel(PlayerType playerType) {
            return  this.playersMap.get(playerType).clone();
        }
      
}
