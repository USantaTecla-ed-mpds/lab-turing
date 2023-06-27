package main.es.labturing.dessignPaterns.composite;

public interface TreeNumbers {

    public int sum();

    public void add(TreeNumbers treeNumbers);

    public void remove(TreeNumbers treeNumbers);

    public int numberOfNodes();

    public int higher();

    public boolean isComposite();
}
