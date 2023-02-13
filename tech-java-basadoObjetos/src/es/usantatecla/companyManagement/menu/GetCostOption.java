package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class GetCostOption implements Option{

    @Override
    public String showTitle(Languaje languaje) {
        return Messages.TOTAL_COST.getCustomLanguajeMessage(languaje.ordinal());
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.getCost();
    }


}
