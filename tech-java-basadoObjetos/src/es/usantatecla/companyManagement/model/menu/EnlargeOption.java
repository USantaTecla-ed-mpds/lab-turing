package es.usantatecla.companyManagement.model.menu;

import es.usantatecla.companyManagement.model.Languaje;
import es.usantatecla.companyManagement.model.Message;
import es.usantatecla.companyManagement.view.ServicesContractView;

public class EnlargeOption implements Option{

    @Override
    public String showTitle(Languaje languaje) {
        return Message.ENLARGE.getCustomLanguajeMessage(languaje);
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.enlarge(); 
    }  
}
