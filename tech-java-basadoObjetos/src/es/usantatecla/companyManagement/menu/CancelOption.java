package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class CancelOption implements Option{

    @Override
    public String showTitle(Languaje languaje) {
        return Message.CANCEL.getCustomLanguajeMessage(languaje); 
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.cancel();
    } 
}
