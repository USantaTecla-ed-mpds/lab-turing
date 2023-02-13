package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class ShiftOption implements Option{

    @Override
    public String showTitle(Languaje languaje) {
        return Message.SHIFT.getCustomLanguajeMessage(languaje);
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.shift();        
    }  
}
