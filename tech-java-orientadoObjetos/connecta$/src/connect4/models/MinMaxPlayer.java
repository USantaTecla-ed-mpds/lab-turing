package connect4.models;

public class MinMaxPlayer extends Player {
    private final int maxSteps = 6;
    private static int MAX_COST = 2;
    private static int OTHER_COST = 0;
    private static int MIN_COST = -2;

    public MinMaxPlayer(Color color, Board board) {
        super(color, board);
    }

    public int getColumn() {
        int[] uncompletedColumns = this.getBoard().getUncompletedColumns();
        int bestColumn = uncompletedColumns[(int) Math.floor(Math.random() * uncompletedColumns.length)];
        int maxCost = MinMaxPlayer.MIN_COST;
        for (int column : uncompletedColumns) {
            this.getBoard().dropToken(column, this.getColor());
            int minCost = this.getMinCost(0);
            this.getBoard().removeTop(column);
            if (minCost > maxCost) {
                maxCost = minCost;
                bestColumn = column;
            }
        }

        return bestColumn;
    }

    private int getMinCost(int steps) {
        if (this.isEnd(steps)) {
            return this.getCost(false);
        }
        int minCost = MinMaxPlayer.MAX_COST;
        for (int column : this.getBoard().getUncompletedColumns()) {
            this.getBoard().dropToken(column, this.getColor().getOpposite());
            int maxCost = this.getMaxCost(steps + 1);
            this.getBoard().removeTop(column);
            if (maxCost < minCost)
                minCost = maxCost;
        }
        return minCost;
    }

    private int getMaxCost(int steps) {
        if (this.isEnd(steps)) {
            return this.getCost(true);
        }
        int maxCost = MinMaxPlayer.MIN_COST;
        for (int column : this.getBoard().getUncompletedColumns()) {
            this.getBoard().dropToken(column, this.getColor());
            int cost = this.getMinCost(steps + 1);
            this.getBoard().removeTop(column);
            if (cost > maxCost)
                maxCost = cost;
        }
        return maxCost;
    }

    private boolean isEnd(int steps) {
        return steps == this.maxSteps || this.getBoard().isGameFinished() || this.getBoard().isAlmostWinner();
    }

    private int getCost(boolean isOpposite) {
        if (this.getBoard().isWinner()) {
            if (isOpposite) {
                return MinMaxPlayer.MIN_COST;
            } else {
                return MinMaxPlayer.MAX_COST;
            }
        }
        if (this.getBoard().isAlmostWinner()) {
            if (isOpposite) {
                return MinMaxPlayer.MIN_COST / 2;
            } else {
                return MinMaxPlayer.MAX_COST / 2;
            }
        }
        return MinMaxPlayer.OTHER_COST;
    }

    public void accept(PlayerVisitor visitor) {
        visitor.visit(this);
    }

}
