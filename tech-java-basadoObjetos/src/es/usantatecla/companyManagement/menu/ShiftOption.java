package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class ShiftOption implements Option{

    @Override
    public String showTitle(Languaje languaje) {
        return Messages.SHIFT.getCustomLanguajeMessage(languaje.ordinal());
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.shift();        
    }
    
}
