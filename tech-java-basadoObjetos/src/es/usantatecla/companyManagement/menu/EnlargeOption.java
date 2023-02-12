package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class EnlargeOption implements Option{

    @Override
    public String showTitle(Languaje languaje) {
        return Messages.ENLARGE.getTitle(languaje.ordinal());
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.enlarge(); 
    }
    
}
