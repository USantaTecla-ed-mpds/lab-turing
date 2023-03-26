package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.views.MessageManager;
import main.es.pbover.utils.menu.Option;

public abstract class SelectLanguageOption extends Option {

    protected MessageManager messageManager;

    public SelectLanguageOption(String title) {
        super(title);
        this.messageManager = MessageManager.getInstance();
    }

}
