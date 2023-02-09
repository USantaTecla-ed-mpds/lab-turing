package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContract;
import es.usantatecla.companyManagement.ServicesContractView;

public class ShowOption implements Option{

    @Override
    public String showTitle() {
        return "Mostrar (fecha - rango de horas)";     
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.writeln();
    }
    
}
