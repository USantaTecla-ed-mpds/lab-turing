package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.StageValue;

public class Stage {
    private StageValue stageValue;

    public Stage() {
        this.reset();
    }

    public void reset() {
        this.stageValue = StageValue.INITIAL;
    }

    public void next() {
        assert this.stageValue != StageValue.EXIT;

        this.stageValue = StageValue.values()[this.stageValue.ordinal() + 1];
    }

    public StageValue getValueStage() {
        return this.stageValue;
    }

    public void setStageValue(StageValue stageValue) {
        this.stageValue = stageValue;
    }
}
