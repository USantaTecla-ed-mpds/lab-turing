package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class ShiftOption implements Option{

    @Override
    public String showTitle(int languaje) {
        return Languaje.SHIFT.getTitle(languaje);
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.shift();        
    }
    
}
