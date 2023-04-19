package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.PlayerType;

public class MinMaxPlayer extends MachinePlayer {
    private final int maxSteps = 6;
    private static int MAX_COST = 2;
    private static int OTHER_COST = 0;
    private static int MIN_COST = -2;
    private DraftBoard draftBoard;

    public MinMaxPlayer(Board board) {
        super(board);
        this.type = PlayerType.MINMAX;
    }

    public int getColumn() {
        this.draftBoard = new DraftBoard(this.getBoard());
        int[] uncompletedColumns = this.draftBoard.getUncompletedColumns();
        int bestColumn = uncompletedColumns[(int) Math.floor(Math.random() * uncompletedColumns.length)];
        int maxCost = MinMaxPlayer.MIN_COST;
        for (int column : uncompletedColumns) {
            this.draftBoard.dropToken(column, this.getColor());
            int minCost = this.getMinCost(0);
            this.draftBoard.removeTop(column);
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
        for (int column : this.draftBoard.getUncompletedColumns()) {
            this.draftBoard.dropToken(column, this.getColor().getOpposite());
            int maxCost = this.getMaxCost(steps + 1);
            this.draftBoard.removeTop(column);
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
        for (int column : this.draftBoard.getUncompletedColumns()) {
            this.draftBoard.dropToken(column, this.getColor());
            int cost = this.getMinCost(steps + 1);
            this.draftBoard.removeTop(column);
            if (cost > maxCost)
                maxCost = cost;
        }
        return maxCost;
    }

    private boolean isEnd(int steps) {
        return steps == this.maxSteps || this.draftBoard.isGameFinished() || this.draftBoard.isAlmostWinner();
    }

    private int getCost(boolean isOpposite) {
        if (this.draftBoard.isWinner()) {
            if (isOpposite) {
                return MinMaxPlayer.MIN_COST;
            } else {
                return MinMaxPlayer.MAX_COST;
            }
        }
        if (this.draftBoard.isAlmostWinner()) {
            if (isOpposite) {
                return MinMaxPlayer.MIN_COST / 2;
            } else {
                return MinMaxPlayer.MAX_COST / 2;
            }
        }
        return MinMaxPlayer.OTHER_COST;
    }

}
