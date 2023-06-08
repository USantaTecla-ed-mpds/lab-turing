package main.es.labturing.dessignPaterns.decorator;

public abstract class MessageDecorator implements Message{

    protected Message message;

    public MessageDecorator(Message message){
        this.message = message;
    }

    // @Override
    // public abstract String show();

    @Override
    public String show(){
        return this.message.show();
    }  
    
}
