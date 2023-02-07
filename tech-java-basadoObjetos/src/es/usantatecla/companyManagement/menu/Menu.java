package es.usantatecla.companyManagement.menu;

import java.util.ArrayList;
import java.util.List;

import es.usantatecla.utils.Console;
import es.usantatecla.companyManagement.ServicesContract;

public class Menu {

    private Console console;
    private List<Option> options;
    private ServicesContract servicesContract;

    public Menu(ServicesContract servicesContract) {
        this.servicesContract = servicesContract;
        this.console = new Console();
        this.options = new ArrayList<>();
        this.options.add(new ShowOption());
        this.options.add(new CancelOption());
        this.options.add(new GetCostOption());
        this.options.add(new ExitOption());
    }

    public void show(){
        int selectedOption = 0;
        boolean validOption = false;
        do{
            this.console.writeln("ACCIONES DISPONIBLES");
            for (int i = 0; i < this.options.size(); i++) {
                this.console.writeln(i + 1 + ": " + this.options.get(i).showTitle());
            }
            selectedOption = this.console.readInt("Seleccionar [1-" + this.options.size() + "]: ");
            validOption = selectedOption > 0 && selectedOption <= this.options.size();
            if (validOption){
                this.options.get(selectedOption - 1).execute(this.servicesContract);
            } else {
                this.console.writeln("ERROR! Introduzca una opción válida [1-" + this.options.size() + "] \n");
            }
        }while(selectedOption != this.options.size());
    }
}
