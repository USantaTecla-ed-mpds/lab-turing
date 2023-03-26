package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.views.Language;

public class SpanishOption extends SelectLanguageOption {

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
