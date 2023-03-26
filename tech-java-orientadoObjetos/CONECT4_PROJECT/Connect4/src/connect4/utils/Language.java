package connect4.utils;

public enum Language {

    SPANISH("messages_es"),
    ENGLISH("messages_en");

    private String fileName;
    private final String fileExtension = ".properties";

    private Language(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName + fileExtension;
    }
}
