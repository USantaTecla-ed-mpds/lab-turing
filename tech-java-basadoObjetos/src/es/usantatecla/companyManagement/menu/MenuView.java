package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;
import es.usantatecla.utils.Console;

public class MenuView {
    
    private Menu menu;
    private ServicesContractView servicesContractView;

    public MenuView(ServicesContractView servicesContractView){
        this.servicesContractView = servicesContractView;
        this.menu = new Menu();
    }

    public void show(Languaje languaje){
        Console console = new Console();
        int selectedOption = 0;
        boolean validOption = false;
        console.writeln(
            Message.MENU_TITLE_PRE.getCustomLanguajeMessage(languaje.ordinal())
             + 
            this.servicesContractView.getName() 
             +
            Message.MENU_TITLE_POST.getCustomLanguajeMessage(languaje.ordinal())
             + 
            this.servicesContractView.getYear());
        do{
            console.writeln(Message.MENU_SUBTITLE.getCustomLanguajeMessage(languaje.ordinal()));
            for (int i = 0; i < this.menu.getSize(); i++) {
                console.writeln(i + 1 + Message.MENU_SEPARATOR.getCustomLanguajeMessage(languaje.ordinal()) + this.menu.getOption(i).showTitle(languaje));
            }
            selectedOption = console.readInt(
                Message.MENU_READ_ERROR_PRE.getCustomLanguajeMessage(languaje.ordinal())
                 + 
                this.menu.getSize() 
                 + 
                 Message.MENU_READ_ERROR_POST.getCustomLanguajeMessage(languaje.ordinal()));
            validOption = selectedOption > 0 && selectedOption <= this.menu.getSize();
            if (validOption){
                this.menu.getOption(selectedOption - 1).execute(this.servicesContractView);
            } else {
                console.writeln(
                    Message.MENU_SELECT_ERROR_PRE.getCustomLanguajeMessage(languaje.ordinal())
                     + 
                    this.menu.getSize()
                      + 
                    Message.MENU_SELECT_ERROR_POST.getCustomLanguajeMessage(languaje.ordinal()));
            }
        }while(selectedOption != this.menu.getSize());
    }
}
