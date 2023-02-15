package es.usantatecla.companyManagement.model.menu;

import es.usantatecla.companyManagement.view.ServicesContractView;

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
