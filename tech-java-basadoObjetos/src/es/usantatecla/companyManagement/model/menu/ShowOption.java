package es.usantatecla.companyManagement.model.menu;

import es.usantatecla.companyManagement.view.ServicesContractView;

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
