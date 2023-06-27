package main.es.labturing.dessignPaterns.composite;

public class Client {

    public void run(){
        TreeNumbersComposite numbersRoot = new TreeNumbersComposite("numbersRoot");
        TreeNumbersLeaf one = new TreeNumbersLeaf(1);
        TreeNumbersLeaf two = new TreeNumbersLeaf(2);
        numbersRoot.add(one);
        numbersRoot.add(two);
        TreeNumbersComposite firstComposite = new TreeNumbersComposite("first composite");
        TreeNumbersLeaf three = new TreeNumbersLeaf(3);
        TreeNumbersLeaf four = new TreeNumbersLeaf(4);
        firstComposite.add(three);
        firstComposite.add(four);
        numbersRoot.add(firstComposite);


        System.out.println("numbers sum: " + numbersRoot.sum());
    }

    public static void main(String[] args) {
        new Client().run();
    }
    
}
