package es.usantatecla.companyManagement.view;

import es.usantatecla.companyManagement.model.menu.Languaje;
import es.usantatecla.companyManagement.model.menu.Menu;
import es.usantatecla.companyManagement.model.menu.Message;
import es.usantatecla.utils.Console;

public class MenuView {

    private Menu menu;
    private ServicesContractView servicesContractView;

    public MenuView(ServicesContractView servicesContractView) {
        this.servicesContractView = servicesContractView;
        this.menu = new Menu();
    }

    public void show(Languaje languaje) {
        Console console = new Console();
        int selectedOption = 0;
        boolean validOption = false;
        console.writeln(
                Message.MENU_TITLE_PRE.getCustomLanguajeMessage(languaje)
                        +
                        this.servicesContractView.getName()
                        +
                        Message.MENU_TITLE_POST.getCustomLanguajeMessage(languaje)
                        +
                        this.servicesContractView.getYear());
        do {
            console.writeln(Message.MENU_SUBTITLE.getCustomLanguajeMessage(languaje));
            for (int i = 0; i < this.menu.getSize(); i++) {
                console.writeln(i + 1
                        +
                        Message.MENU_SEPARATOR.getCustomLanguajeMessage(languaje)
                        +
                        this.menu.getOption(i).showTitle(languaje));
            }
            selectedOption = console.readInt(
                    Message.MENU_READ_ERROR_PRE.getCustomLanguajeMessage(languaje)
                            +
                            this.menu.getSize()
                            +
                            Message.MENU_READ_ERROR_POST.getCustomLanguajeMessage(languaje));
            validOption = selectedOption > 0 && selectedOption <= this.menu.getSize();
            if (validOption) {
                this.menu.getOption(selectedOption - 1).execute(this.servicesContractView);
            } else {
                console.writeln(
                        Message.MENU_SELECT_ERROR_PRE.getCustomLanguajeMessage(languaje)
                                +
                                this.menu.getSize()
                                +
                                Message.MENU_SELECT_ERROR_POST.getCustomLanguajeMessage(languaje));
            }
        } while (selectedOption != this.menu.getSize());
    }
}
