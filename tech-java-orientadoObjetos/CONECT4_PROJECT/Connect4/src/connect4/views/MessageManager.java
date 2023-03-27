package connect4.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;

import connect4.utils.Console;
import connect4.utils.Language;
import connect4.utils.exceptions.MessageNotFoundException;

public class MessageManager {

    private Language language;
    private HashMap<String, String> messages = new HashMap<String, String>();
    private static MessageManager instance;
    private String relativePath;

    private MessageManager() {
    }

    public static MessageManager getInstance() {
        if (MessageManager.instance == null) {
            MessageManager.instance = new MessageManager();
        }
        return MessageManager.instance;
    }

    public void initialize(String path, Language language) throws FileNotFoundException, IOException {
        this.setRelativePath(path);
        this.setLanguage(language);
    }

    private void setRelativePath(String path) {
        this.relativePath = path;
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

    public String getMessage(String key) throws MessageNotFoundException {
        checkIfMessageExist(key);
        return this.messages.get(key);
    }

    public String getMessage(String key, Object... values) throws MessageNotFoundException {
        checkIfMessageExist(key);
        String formattedMessage = MessageFormat.format(this.messages.get(key), values);
        return formattedMessage;
    }

    public void write(String key) throws MessageNotFoundException {
        checkIfMessageExist(key);
        Console.getInstance().write(this.messages.get(key));
    }

    public void write(String key, Object... values) throws MessageNotFoundException {
        checkIfMessageExist(key);
        String formattedMessage = MessageFormat.format(this.messages.get(key), values);
        Console.getInstance().write(formattedMessage);
    }

    public void writeln(String key) throws MessageNotFoundException {
        checkIfMessageExist(key);
        Console.getInstance().writeln(this.messages.get(key));
    }

    public void writeln(String key, Object... values) throws MessageNotFoundException {
        checkIfMessageExist(key);
        String formattedMessage = MessageFormat.format(this.messages.get(key), values);
        Console.getInstance().writeln(formattedMessage);
    }

    private void checkIfMessageExist(String key) throws MessageNotFoundException {
        if (!this.messages.containsKey(key))
            throw new MessageNotFoundException("Mensaje no encontrado", key);
    }

}
