package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class CancelOption implements Option{

    @Override
    public String showTitle() {
        return "Cancelar (fecha)";   
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.cancel();
    }
    
}
