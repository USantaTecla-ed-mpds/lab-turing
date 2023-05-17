package main.es.labturing.connect4.models;

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
}
