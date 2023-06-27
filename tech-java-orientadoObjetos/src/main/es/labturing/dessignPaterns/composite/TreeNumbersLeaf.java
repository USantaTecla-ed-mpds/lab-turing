package main.es.labturing.dessignPaterns.composite;

public class TreeNumbersLeaf implements TreeNumbers{

    private int value;
    
    public TreeNumbersLeaf(int value){
        this.value = value;
    }

    @Override
    public int sum() {
        return this.value;
    }

    @Override
    public void add(TreeNumbers treeNumbers) {
        //intentional void
    }

    @Override
    public void remove(TreeNumbers treeNumbers) {
        //intentional void
    }

    @Override
    public int numberOfNodes() {
        return 0;
    }

    @Override
    public int higher() {
        return this.value;
    }

    @Override
    public boolean isComposite() {
       return false;
    }
    
}
