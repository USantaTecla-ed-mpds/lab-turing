package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class ShowOption implements Option{

    @Override
    public String showTitle(Languaje languaje) {
        return Message.SHOW.getCustomLanguajeMessage(languaje);     
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.writeln();
    }
    
}
