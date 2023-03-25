package connect4.models.exceptions;

public class MessageException extends Exception {

    private String key;

    public MessageException(String message, String key) {
        super(message + " : " + key);
        this.key = key;
    }

    protected String getKey() {
        return this.key;
    }
}
