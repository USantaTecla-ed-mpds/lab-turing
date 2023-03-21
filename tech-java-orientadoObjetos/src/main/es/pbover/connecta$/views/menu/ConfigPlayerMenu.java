package main.es.pbover.connecta$.views.menu;

import main.es.pbover.connecta$.models.Turn;

public class ConfigPlayerMenu extends TurnMenuForTwoPlayers {

    public ConfigPlayerMenu(Turn turn) {
        super("Select #number player type", turn);
    }

    @Override
    protected void addOptions() {
        this.add(new CreateHumanPlayerOption(this.turn));
        this.add(new CreateRandomPlayerOption(this.turn));
        this.add(new CreateIAPlayerOption(this.turn));

    }

}
