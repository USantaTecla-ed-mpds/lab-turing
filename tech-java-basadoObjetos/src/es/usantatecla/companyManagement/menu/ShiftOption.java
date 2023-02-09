package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class ShiftOption implements Option{

    @Override
    public String showTitle() {
        return "Desplazar (rango de horas)";
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.shift();        
    }
    
}
