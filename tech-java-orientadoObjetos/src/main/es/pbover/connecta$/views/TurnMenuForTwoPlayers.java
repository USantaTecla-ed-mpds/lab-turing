package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.models.Turn;

public abstract class TurnMenuForTwoPlayers extends TurnMenu{

    private int showMenuTimesCounter;

    public TurnMenuForTwoPlayers(String title, Turn turn) {
        super(title, turn);
        this.showMenuTimesCounter = 0;
    }

    @Override
    public void interact() {
        this.addOptions();
        do {
            this.interact_();
            this.showMenuTimesCounter++;
        } while (this.showMenuTimesCounter != this.turn.getNumberPlayers());
        this.turn.reset();
    }
}
