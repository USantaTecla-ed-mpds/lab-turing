package main.es.labturing.dessignPaterns.decorator;

public class MessageImpl implements Message{

    private String text;

    public MessageImpl(String text){
        this.text = text;
    }

    @Override
    public String show() {
        return this.text;
    }
}
