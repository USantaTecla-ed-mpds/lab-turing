package main.es.labturing.connect4.views;

public enum Language {

    SPANISH("es"),
    ENGLISH("en");

    private String fileName;

    private Language(String fileName) {
        this.fileName = "messages_"+fileName+".properties";
    }

    public String getFileName() {
        return this.fileName;
    }
}
