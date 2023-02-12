package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;
import es.usantatecla.utils.Console;

public class MenuView {
    
    private Menu menu;
    private ServicesContractView servicesContractView;
    private final int LANGUAJE = 0; //0 spanish, 1 english 

    public MenuView(ServicesContractView servicesContractView){
        this.servicesContractView = servicesContractView;
        this.menu = new Menu();
    }

    public void show(){
        Console console = new Console();
        int selectedOption = 0;
        boolean validOption = false;
        console.writeln("Gestión del contrato \"" + this.servicesContractView.getName() + "\" para el año " + this.servicesContractView.getYear());
        do{
            console.writeln("ACCIONES DISPONIBLES");
            for (int i = 0; i < this.menu.getSize(); i++) {
                console.writeln(i + 1 + ": " + this.menu.getOption(i).showTitle(LANGUAJE));
            }
            selectedOption = console.readInt("Seleccionar [1-" + this.menu.getSize() + "]: ");
            validOption = selectedOption > 0 && selectedOption <= this.menu.getSize();
            if (validOption){
                this.menu.getOption(selectedOption - 1).execute(this.servicesContractView);
            } else {
                console.writeln("ERROR! Introduzca una opción válida [1-" + this.menu.getSize() + "] \n");
            }
        }while(selectedOption != this.menu.getSize());
    }
}
