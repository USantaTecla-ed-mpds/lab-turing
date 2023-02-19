package es.usantatecla.companyManagement.view;

import es.usantatecla.companyManagement.model.Languaje;
import es.usantatecla.companyManagement.model.Message;
import es.usantatecla.companyManagement.model.menu.Menu;
import es.usantatecla.utils.Console;

public class MenuView {

    private Menu menu;
    private ServicesContractView servicesContractView;

    public MenuView(ServicesContractView servicesContractView) {
        this.servicesContractView = servicesContractView;
        this.menu = new Menu();
    }

    public void show(Languaje languaje) {
        int selectedOption;
        this.showMenuTitle(languaje);
        do {
            this.showSubMenuTitle(languaje);
            for (int i = 0; i < this.menu.getSize(); i++) {
                this.showOptionTitle(i, languaje);
            }
            selectedOption = this.readUserOption(languaje);
            boolean validOption = selectedOption > 0 && selectedOption <= this.menu.getSize();
            if (validOption) {
                this.menu.getOption(selectedOption - 1).execute(this.servicesContractView);
            } else {
                this.showErrorSelectedOption(languaje);
            }
        } while (selectedOption != this.menu.getSize());
    }

    private void showMenuTitle(Languaje languaje) {
        new Console().writeln(
            Message.MENU_TITLE_PRE.getCustomLanguajeMessage(languaje)
                +
                this.servicesContractView.getName()
                +
                Message.MENU_TITLE_POST.getCustomLanguajeMessage(languaje)
                +
                this.servicesContractView.getYear());
    }

    private void showSubMenuTitle(Languaje languaje) {
        new Console().writeln(Message.MENU_SUBTITLE.getCustomLanguajeMessage(languaje));
    }

    private void showOptionTitle(int i, Languaje languaje) {
        new Console().writeln(
            i + 1
                +
                Message.MENU_SEPARATOR.getCustomLanguajeMessage(languaje)
                +
                this.menu.getOption(i).showTitle(languaje));
    }

    private int readUserOption(Languaje languaje){
        return new Console().readInt(
            Message.MENU_READ_ERROR_PRE.getCustomLanguajeMessage(languaje)
                    +
                    this.menu.getSize()
                    +
                    Message.MENU_READ_ERROR_POST.getCustomLanguajeMessage(languaje));
    }

    private void showErrorSelectedOption(Languaje languaje){
        new Console().writeln(
            Message.MENU_SELECT_ERROR_PRE.getCustomLanguajeMessage(languaje)
                    +
                    this.menu.getSize()
                    +
                    Message.MENU_SELECT_ERROR_POST.getCustomLanguajeMessage(languaje));
    }
}
