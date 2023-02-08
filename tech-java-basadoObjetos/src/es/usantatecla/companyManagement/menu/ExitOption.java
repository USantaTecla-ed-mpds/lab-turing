package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContract;
import es.usantatecla.utils.Console;

public class ExitOption implements Option{

    @Override
    public String showTitle() {
        return "Salir";    
    }

    @Override
    public void execute(ServicesContract servicesContract) {
        new Console().writeln("\nHasta la próxima!");
    }
    
}
