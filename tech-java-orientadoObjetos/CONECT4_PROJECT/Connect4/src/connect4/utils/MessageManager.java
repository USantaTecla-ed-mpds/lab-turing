package connect4.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;

public class MessageManager {

    private Language language;
    private HashMap<String, String> messages = new HashMap<String, String>();
    private static MessageManager instance;
    private String relativePath;

    private MessageManager() {
    }

    public static MessageManager getInstance(String relativePath) throws FileNotFoundException, IOException {
        if (MessageManager.instance == null) {
            MessageManager.instance = new MessageManager();
        }
        MessageManager.instance.setPath(relativePath);
        return MessageManager.instance;
    }

    private void setPath(String path) {
        this.relativePath = path;
    }

    public static MessageManager getInstance() {
        if (MessageManager.instance == null) {
            MessageManager.instance = new MessageManager();
        }
        return MessageManager.instance;
    }

    public void setLanguage(Language language) throws FileNotFoundException, IOException {
        this.messages = new HashMap<String, String>();
        this.language = language;
        this.readFile();
    }

    private void readFile() throws FileNotFoundException, IOException {
        File file = new File(this.relativePath + this.language.getFileName());
        BufferedReader input = null;
        input = new BufferedReader(new FileReader(file));
        String line;
        while ((line = input.readLine()) != null) {
            String[] separated = line.split("=");
            separated[0] = separated[0].trim();
            separated[1] = separated[1].trim().replace("\"", "");
            this.messages.put(separated[0], separated[1]);
        }
        input.close();
    }

    public String getMessage(String key) {
        return this.messages.get(key);
    }

    public String getFormatedMessage(String key, Object... values) {
        String formattedMessage = MessageFormat.format(this.messages.get(key), values);
        return formattedMessage;
    }

    public void write(String key) {
        Console.getInstance().write(this.messages.get(key));
    }

    public void write(String key, Object... values) {
        String formattedMessage = MessageFormat.format(this.messages.get(key), values);
        Console.getInstance().write(formattedMessage);
    }

    public void writeln(String key) {
        Console.getInstance().writeln(this.messages.get(key));
    }

    public void writeln(String key, Object... values) {
        String formattedMessage = MessageFormat.format(this.messages.get(key), values);
        Console.getInstance().writeln(formattedMessage);
    }

}
