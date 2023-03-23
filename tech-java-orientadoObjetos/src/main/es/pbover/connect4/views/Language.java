package main.es.pbover.connect4.views;

public enum Language {

    SPANISH("messages_es.properties"),
    ENGLISH("messages_en.properties");

    private String fileName;

    private Language(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}
