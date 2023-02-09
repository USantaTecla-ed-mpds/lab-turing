package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class ExitOption implements Option{

    @Override
    public String showTitle() {
        return "Salir";    
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.exit();
    }
    
}
