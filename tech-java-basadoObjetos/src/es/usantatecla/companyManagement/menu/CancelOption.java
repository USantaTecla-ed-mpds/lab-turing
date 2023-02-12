package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class CancelOption implements Option{

    @Override
    public String showTitle(int languaje) {
        return Languaje.CANCEL.getTitle(languaje); 
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.cancel();
    }
    
}
