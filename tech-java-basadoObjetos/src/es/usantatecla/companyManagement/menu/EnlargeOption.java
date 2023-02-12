package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class EnlargeOption implements Option{

    @Override
    public String showTitle(int languaje) {
        return Languaje.ENLARGE.getTitle(languaje);
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.enlarge(); 
    }
    
}
