package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.views.MessageManager;
import main.es.pbover.utils.menu.Option;

public abstract class LanguageOption extends Option {

    protected MessageManager messageManager;

    public LanguageOption(String title) {
        super(title);
        this.messageManager = MessageManager.getInstance();
    }

}
