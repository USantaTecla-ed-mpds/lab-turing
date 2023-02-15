package es.usantatecla.companyManagement.model.menu;

import es.usantatecla.companyManagement.view.ServicesContractView;

public class GetCostOption implements Option{

    @Override
    public String showTitle(Languaje languaje) {
        return Message.TOTAL_COST.getCustomLanguajeMessage(languaje);
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.getCost();
    }
}
