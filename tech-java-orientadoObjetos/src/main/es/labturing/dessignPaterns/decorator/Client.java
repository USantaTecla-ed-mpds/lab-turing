package main.es.labturing.dessignPaterns.decorator;

public class Client {
    
    public static void main(String[] args) {
        new Client().run();
    }

    public void run(){
        Message message = new MessageImpl("xavi");
        System.out.println(message.show());

        AddAsteriscDecorator addAsteriscDecorator = new AddAsteriscDecorator(message);
        System.out.println(addAsteriscDecorator.show());

        AddLinesDecorator addLinesDecorator = new AddLinesDecorator(message);
        System.out.println(addLinesDecorator.show());

        AddLinesDecorator addLinesDecorator2 = new AddLinesDecorator(addAsteriscDecorator);
        System.out.println(addLinesDecorator2.show());
    }
}
