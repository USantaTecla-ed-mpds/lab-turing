package connect4.models;

public enum PlayerFactory {
    HumanPlayer(0) {
        @Override
        public Player buildPlayer(Color color, Board board) {
            return new HumanPlayer(color, board);
        }
    },
    RandomPlayer(1) {
        @Override
        public Player buildPlayer(Color color, Board board) {
            return new RandomPlayer(color, board);
        }
    },
    MinMaxPlayer(2) {
        @Override
        public Player buildPlayer(Color color, Board board) {
            return new MinMaxPlayer(color, board);
        }
    };

    private int option;

    private PlayerFactory(int option) {
        this.option = option;
    }

    public abstract Player buildPlayer(Color color, Board board);

    public static Player buildPlayerFromOption(int option, Color color, Board board) {
        for (PlayerFactory playerFactory : PlayerFactory.values()) {
            if (playerFactory.option == option) {
                return playerFactory.buildPlayer(color, board);
            }
        }
        return getDefaultPlayer(color, board);
    }

    private static Player getDefaultPlayer(Color color, Board board) {
        return PlayerFactory.values().length > 0
                ? PlayerFactory.values()[0].buildPlayer(color, board)
                : null;
    }

}
