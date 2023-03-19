package connect4.models;

public enum PlayerFactory {
    HumanPlayer(0) {
        @Override
        public Player getPlayer(Color color, Board board) {
            return new HumanPlayer(color, board);
        }
    },
    RandomPlayer(1) {
        @Override
        public Player getPlayer(Color color, Board board) {
            return new RandomPlayer(color, board);
        }
    },
    MinMaxPlayer(2) {
        @Override
        public Player getPlayer(Color color, Board board) {
            return new MinMaxPlayer(color, board);
        }
    };

    private int option;

    private PlayerFactory(int option) {
        this.option = option;
    }

    public abstract Player getPlayer(Color color, Board board);

    public static Player getPlayerByOption(int option, Color color, Board board) {
        for (PlayerFactory playerFactory : PlayerFactory.values()) {
            if (playerFactory.option == option) {
                return playerFactory.getPlayer(color, board);
            }
        }
        return null;
    }

}
