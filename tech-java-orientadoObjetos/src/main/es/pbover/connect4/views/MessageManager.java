package main.es.pbover.connect4.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;

import main.es.pbover.utils.Console;

public class MessageManager {

    private Language language;
    private HashMap<String, String> messages = new HashMap<String, String>();
    private static MessageManager instance;

    private MessageManager() {
    }

    public static MessageManager getInstance() {
        if (MessageManager.instance == null) {
            MessageManager.instance = new MessageManager();
        }
        return MessageManager.instance;
    }

    public void setLanguage(Language language) throws FileNotFoundException, IOException {
        this.language = language;
        this.readFile();
    }

    private void readFile() throws FileNotFoundException, IOException { // pasar como parametro path
        String path = "tech-java-orientadoObjetos/src/main/es/pbover/connect4/resources/";
        File file = new File(path + this.language.getFileName());
        BufferedReader input = new BufferedReader(new FileReader(file));
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

    public void writeln(String key) {
        Console.getInstance().writeln(this.messages.get(key));
    }

    public void writeFormatedMessage(String key, Object... values) {
        Console.getInstance().write(MessageFormat.format(this.messages.get(key), values));

    }
    public void writelnFormatedMessage(String key, Object... values) {
        Console.getInstance().writeln(MessageFormat.format(this.messages.get(key), values));

    }

}
