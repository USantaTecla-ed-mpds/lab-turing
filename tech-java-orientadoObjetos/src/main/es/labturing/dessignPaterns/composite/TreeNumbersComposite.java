package main.es.labturing.dessignPaterns.composite;

import java.util.ArrayList;
import java.util.List;

public class TreeNumbersComposite implements TreeNumbers{

    private List<TreeNumbers> treeNumbersList;
    private String name;

    public TreeNumbersComposite(String name){
        this.name = name;
        this.treeNumbersList = new ArrayList<>(); //?
    }

    @Override
    public int sum() {
        int acomulate = 0;
        for (TreeNumbers treeNumber : treeNumbersList) {
            acomulate += treeNumber.sum();
        }
        return acomulate;
    }

    @Override
    public void add(TreeNumbers treeNumbers) {
        this.treeNumbersList.add(treeNumbers);
    }

    @Override
    public void remove(TreeNumbers treeNumbers) {
        this.treeNumbersList.remove(treeNumbers);
    }

    @Override
    public int numberOfNodes() {
        return this.treeNumbersList.size();
    }

    @Override
    public int higher() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'higher'");
    }

    @Override
    public boolean isComposite() {
        return true;
    }
    
}
