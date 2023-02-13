package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class ExitOption implements Option{

    @Override
    public String showTitle(Languaje languaje) {
        return Message.EXIT.getCustomLanguajeMessage(languaje.ordinal());    
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.exit();
    }
    
}
