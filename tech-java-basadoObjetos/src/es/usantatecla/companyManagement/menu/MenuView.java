package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContract;
import es.usantatecla.utils.Console;

public class MenuView {
    
    private Menu menu;
    private ServicesContract servicesContract;
    private Console console;

    public MenuView(ServicesContract servicesContract){
        this.servicesContract = servicesContract;
        this.menu = new Menu();
        this.console = new Console();
    }

    public void show(){
        int selectedOption = 0;
        boolean validOption = false;
        do{
            this.console.writeln("ACCIONES DISPONIBLES");
            for (int i = 0; i < this.menu.getSize(); i++) {
                this.console.writeln(i + 1 + ": " + this.menu.getOption(i).showTitle());
            }
            selectedOption = this.console.readInt("Seleccionar [1-" + this.menu.getSize() + "]: ");
            validOption = selectedOption > 0 && selectedOption <= this.menu.getSize();
            if (validOption){
                this.menu.getOption(selectedOption - 1).execute(this.servicesContract);
            } else {
                this.console.writeln("ERROR! Introduzca una opción válida [1-" + this.menu.getSize() + "] \n");
            }
        }while(selectedOption != this.menu.getSize());
    }
}
