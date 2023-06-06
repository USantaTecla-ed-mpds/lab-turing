package main.es.labturing.decorator;

public class AddAsteriscDecorator extends MessageDecorator{

    public AddAsteriscDecorator(Message message){
        super(message);
    }

    @Override
    public String show() {
        return "*******" + super.message.show() + "*****";
    }
    
}
