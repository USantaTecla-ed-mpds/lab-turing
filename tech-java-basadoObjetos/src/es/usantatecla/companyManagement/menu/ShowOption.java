package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContract;

public class ShowOption implements Option{

    @Override
    public String show() {
        return "Mostrar intervalos";     
    }

    @Override
    public void execute(ServicesContract servicesContract) {
        servicesContract.writeln();
    }
    
}
