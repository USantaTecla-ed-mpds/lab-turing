package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class ShowOption implements Option{

    @Override
    public String showTitle(int languaje) {
        return Languaje.SHOW.getTitle(languaje);     
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.writeln();
    }
    
}
