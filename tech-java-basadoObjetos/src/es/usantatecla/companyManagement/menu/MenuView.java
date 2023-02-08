package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContract;
import es.usantatecla.utils.Console;

public class MenuView {
    
    private Menu menu;
    private ServicesContract servicesContract;

    public MenuView(ServicesContract servicesContract){
        this.servicesContract = servicesContract;
        this.menu = new Menu();
    }

    public void show(){
        Console console = new Console();
        int selectedOption = 0;
        boolean validOption = false;
        console.writeln("Gestión del contrato \"" + this.servicesContract.getName() + "\" para el año " + this.servicesContract.getYear());
        do{
            console.writeln("ACCIONES DISPONIBLES");
            for (int i = 0; i < this.menu.getSize(); i++) {
                console.writeln(i + 1 + ": " + this.menu.getOption(i).showTitle());
            }
            selectedOption = console.readInt("Seleccionar [1-" + this.menu.getSize() + "]: ");
            validOption = selectedOption > 0 && selectedOption <= this.menu.getSize();
            if (validOption){
                this.menu.getOption(selectedOption - 1).execute(this.servicesContract);
            } else {
                console.writeln("ERROR! Introduzca una opción válida [1-" + this.menu.getSize() + "] \n");
            }
        }while(selectedOption != this.menu.getSize());
    }
}
