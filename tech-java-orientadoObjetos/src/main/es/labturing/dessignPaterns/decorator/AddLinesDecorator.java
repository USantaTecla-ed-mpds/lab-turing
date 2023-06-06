package main.es.labturing.decorator;

public class AddLinesDecorator extends MessageDecorator{



    public AddLinesDecorator(Message message) {
        super(message);
    }

    @Override
    public String show() {
        return "--------" + super.message.show() + "---------";
    }
    
}
