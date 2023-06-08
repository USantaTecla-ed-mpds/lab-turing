package main.es.labturing.dessignPaterns.decorator;

public class AddAsteriscDecorator extends MessageDecorator{

    public AddAsteriscDecorator(Message message){
        super(message);
    }

    @Override
    public String show() {
        return "*******" + super.message.show() + "*****";
    }
    
}
