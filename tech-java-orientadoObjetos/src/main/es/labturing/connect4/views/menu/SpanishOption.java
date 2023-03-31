package main.es.labturing.connect4.views.menu;

import main.es.labturing.connect4.views.Language;

public class SpanishOption extends LanguageOption {

    public SpanishOption() {
        super("SPANISH");
    }

    public void interact() {
        try {
            this.messageManager.setLanguage(Language.SPANISH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
