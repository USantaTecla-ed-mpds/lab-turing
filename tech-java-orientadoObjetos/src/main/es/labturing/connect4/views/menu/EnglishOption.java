package main.es.labturing.connect4.views.menu;

import main.es.labturing.connect4.views.Language;

public class EnglishOption extends LanguageOption {

    public EnglishOption() {
        super("ENGLISH");
    }

    public void interact() {
        try {
            this.messageManager.setLanguage(Language.ENGLISH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
