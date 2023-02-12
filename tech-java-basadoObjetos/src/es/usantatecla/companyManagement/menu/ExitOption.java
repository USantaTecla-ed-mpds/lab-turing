package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class ExitOption implements Option{

    @Override
    public String showTitle(int languaje) {
        return Languaje.EXIT.getTitle(languaje);    
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.exit();
    }
    
}
