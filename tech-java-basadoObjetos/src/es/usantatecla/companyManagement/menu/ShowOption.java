package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContract;

public class ShowOption implements Option{

    @Override
    public String showTitle() {
        return "Mostrar (fecha - rango de horas)";     
    }

    @Override
    public void execute(ServicesContract servicesContract) {
        servicesContract.writeln();
    }
    
}
